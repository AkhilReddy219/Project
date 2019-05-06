package com.niit;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.autoback.dao.UserDao;
import com.niit.autoback.model.User;

public class UserTestCase {
static UserDao userDao;

	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com");
		userDao = (UserDao) context.getBean("userDao");
	}
	
	@Test
	public void registerUserTest()  
	{
		User userdetail =new User();
		userdetail.setEmailid("user1@gmail.com");
		userdetail.setPassword("password");
		userdetail.setRole("User");
		userdetail.setFirstname("akhil");
		userdetail.setLastname("reddy");
		
		assertTrue("Problem in Registering UserDetail in Database",userDao.registerUser(userdetail));
	
	}

}
