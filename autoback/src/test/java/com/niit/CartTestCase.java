package com.niit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autoback.dao.CartDao;
import com.niit.autoback.model.CartItems;

public class CartTestCase {
static CartDao cartDao;

	@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext("com");
	cartDao=(CartDao) context.getBean("cartDao");
	}
	
	@Ignore
	@Test
	public void addItem() 
	{
		CartItems cart=new CartItems();
		cart.setOrderid(2563);
		cart.setPrice(600);
		cart.setProductid(1);
		cart.setQuantity(2);
		cart.setStatus("In Stock");
		cart.setProductname("Disk Brakes");
		cart.setUsername("Akhil");
		assertEquals("Item cant be added to Cart",true,cartDao.addCartItem(cart));
	}
	
	/*@Ignore*/
	@Test
	public void listCartItems()
	{
		List<CartItems> list= cartDao.listCartItems("Akhil");
		assertTrue("Problem in listing cart items",list.size()>0);
		
		for(CartItems cart:list)
		{
			System.out.println(cart.getProductname()+"  ");
			System.out.println(cart.getProductid()+"  ");
			System.out.println(cart.getPrice()+"  "+cart.getQuantity());
			System.out.println(cart.getStatus()+"  "+cart.getOrderid());
		}
		
	}
}
