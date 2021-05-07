package eCommerce.business.concretes;

import java.util.List;

import eCommerce.business.abstracts.UserService;
import eCommerce.core.EmailService;
import eCommerce.dataAccess.abstracts.UserDao;
import eCommerce.entities.concretes.User;


public class UserManager implements UserService{

	private UserDao userDao;
	private EmailService emailService;
	
	public UserManager(UserDao userDao, EmailService emailService ) {
		super();
		this.userDao = userDao;
		this.emailService = emailService;
	}
	@Override
	public void add(User user) {
		//if(userValidate(user)) {
		userDao.add(user);	
		System.out.println("Log: " + user.getePosta());
		emailService.send(user.getePosta(), "Kay�t oldunuz.");
	//}			
		
	}
	@Override
	public void add(String email) {


		//if(!email.isEmpty()) {
		User user =new User();
		user.setePosta(email);
		userDao.add(user);
		System.out.println("Log2: " + user.getePosta());
		emailService.send(email,"Kay�t oldunuz.");
	//}		
		
	}
	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}		
		
	}
	private boolean userValidate(User user) {
		if(user.getName().length()>=2 && user.getLastName().length()>=2) {
			return true;				
		}
		System.out.println("Ad�n�z ve soyad�n�z minimum 2 karakter olmal�.");
		return false;
	}
	@Override
	public void delete(int userId) {
		userDao.delete(userId);	
		
	}
	@Override
	public User get(String email) {
		return userDao.get(email);
	}
	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getId() +" "+ user.getePosta() +" "+ user.getFullName());
		}
		return userDao.getAll();
	}
	
}
