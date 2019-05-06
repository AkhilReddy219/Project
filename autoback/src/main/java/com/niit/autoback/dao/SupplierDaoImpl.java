package com.niit.autoback.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.autoback.model.Suppliers;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addSupplier(Suppliers supplier) 
	{
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.save(supplier);
			System.out.println("New Supplier Created");
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("New Supplier cannot be saved");
			return false;
		}
	}
	
	public boolean updateSupplier(Suppliers supplier) 
	{
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.update(supplier);
			System.out.println("Supplier Updated");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteSupplier(Suppliers supplier)
	{
		try 
		{
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplier);
			System.out.println("Supplier Deleted");
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public Suppliers getSupplier(int supplierid) 
	{
		Session session=sessionFactory.openSession();
		Suppliers supplier=(Suppliers)session.get(Suppliers.class, supplierid);
		session.close();
		return supplier;
	}

	public List<Suppliers> list() 
	{
		try 
		{
		Session session=sessionFactory.openSession();	
		Query query=session.createQuery("From Suppliers");
		List<Suppliers>list=(List<Suppliers>)query.list();
		session.close();
		return list;
		}
		catch(Exception e)
		{
			System.out.println("Cannot Retrieve Suppliers list");
			return null;	
		}
	}

	public List<Suppliers> listSupplierByCategoryId(int categoryid) 
	{
		try 
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from suppliers where CategoryId=:categoryid");
			query.setParameter("categoryid", categoryid);
			List<Suppliers> list=(List<Suppliers>)query.list();
			session.close();
			return list;
		}
		catch(Exception e)
		{
			System.out.println("Cannot retrieve suppliers based on category");
			return null;
		}
	}

}
