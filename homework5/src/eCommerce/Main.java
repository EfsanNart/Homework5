package eCommerce;

import eCommerce.business.concretes.AuthManager;
import eCommerce.business.concretes.UserManager;
import eCommerce.core.amazonEmail.AmazonMailManagerAdapter;
import eCommerce.core.googleEmail.GoogleMailManagerAdapter;
import eCommerce.dataAccess.concretes.InMemoryUserDao;
import eCommerce.entities.concretes.User;

public class Main {

	

	public static void main(String[] args) {

		
		User ela = new User(1, "Ela", "Efþan", "elaefsan@gmail.com", "123456", true);
		
		
		User hakan = new User(2, "Uður", "Deniz", "uðurdeniz@gmail.com", "147258", false);
		//userManager.update(hakan);
		
		InMemoryUserDao inMemoryUserDao = new InMemoryUserDao();
		GoogleMailManagerAdapter googleMailManagerAdapter = new GoogleMailManagerAdapter();
		AmazonMailManagerAdapter amazonMailManagerAdapter = new  AmazonMailManagerAdapter();
		
		AuthManager authManager =new AuthManager(new UserManager(inMemoryUserDao,googleMailManagerAdapter));
		
		authManager.register(ela);
		UserManager userManager = new UserManager(inMemoryUserDao, amazonMailManagerAdapter);
		userManager.getAll();
		
		
	}

}
