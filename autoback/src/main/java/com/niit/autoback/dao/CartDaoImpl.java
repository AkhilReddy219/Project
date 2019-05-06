package com.niit.autoback.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autoback.model.CartItems;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCartItem(CartItems cartitem) 
	{
		try {
			Session session=sessionFactory.getCurrentSession();
			session.save(cartitem);
			return true;
			}
		catch(Exception e)
		{
			
			return false;
		}
	}

	public boolean deleteCartItem(CartItems cartitem) 
	{
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(cartitem);
			return true;	
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItem(CartItems cartitem) 
	{
		try 
		{
		Session session=sessionFactory.getCurrentSession();
		session.update(cartitem);
		return true;	
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public CartItems getCartItems(int cartitemid) 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			CartItems cart=(CartItems) session.get(CartItems.class,cartitemid);
			session.close();
			return cart;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public List<CartItems> listCartItems(String username) 
	{
		try
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from CartItems where username=:userName");
			query.setParameter("userName", username);
			List<CartItems> listCartItems=(List<CartItems>) query.list();
			return listCartItems;
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
