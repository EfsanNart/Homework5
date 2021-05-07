package eCommerce.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;


public class InMemoryUserDao implements UserDao {
	
	ArrayList<User> users=new ArrayList<User>();

	public InMemoryUserDao() {
		super();
		User user1=new User(1, "Ela", "Efþan", "elaefsan@gmail.com", "123456", true);
		User user2=new User(2, "Hakan", "Alkan", "hakanalkan@gmail.com", "741852", true);
		User user3=new User(3, "Gamze", "Yaþa", "gamzeyasa@gmail.com", "852963", true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);		
	}

	@Override
	public void add(User user) {
		System.out.println("Log inmemory: "+ user.getePosta());
		users.add(user);		
		
	}

	@Override
	public void update(User user) {
		User userToUpdate = users.stream()
				.filter(u -> u.getId() == user.getId())
				.findFirst()
				.orElse(null);
		
		userToUpdate.setePosta(user.getePosta());
		userToUpdate.setName(user.getName());
		userToUpdate.setLastName(user.getLastName());
		userToUpdate.setPassword(user.getPassword());
		userToUpdate.setVerify(user.isVerify());		
		
	}

	@Override
	public void delete(int userId) {
		User userToDelete = users.stream()
				.filter(u -> u.getId() == userId)
				.findFirst()
				.orElse(null);
		
		users.remove(userToDelete);			
		
	}

	@Override
	public User get(String email) {
		User user = users.stream()
				.filter(u -> u.getePosta() == email)
				.findFirst()
				.orElse(null);
		return user;
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}
	
}
