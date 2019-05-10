package com.niit.autoback.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autoback.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean registerUser(User userdetail) 
	{
		try 
		{
			Session session =sessionFactory.getCurrentSession();
			session.save(userdetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateUser(User userdetail) 
	{	
		try 
		{
			Session session =sessionFactory.getCurrentSession();
			session.update(userdetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public User getUser(String username)
	{
		Session session=sessionFactory.openSession();
		User userdetail=(User)session.get(User.class, username);
		session.close();
		return userdetail;
		}
}
