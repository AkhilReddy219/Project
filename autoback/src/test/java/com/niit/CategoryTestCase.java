package com.niit;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.autoback.dao.CategoryDao;
import com.niit.autoback.model.Category;

public class CategoryTestCase {
static CategoryDao categoryDao;

	@BeforeClass
	public static void initialize()
	{
	AnnotationConfigApplicationContext acac=new AnnotationConfigApplicationContext("com");
	categoryDao=(CategoryDao) acac.getBean("categoryDao");
	}
	@Ignore
	@Test
	public void addCategory()
	{
		Category category=new Category();
		category.setCategoryid(1);
		category.setCategoryname("Engine");
		category.setCategorydescription("This has all the products related to engine");
		assertEquals("Category insertion failed",true,categoryDao.insertCategory(category));	
	}
	@Ignore
	@Test
	public void removeCategory()
	{
		Category category=categoryDao.getCategory(1);
		assertEquals("Category removal failed",true,categoryDao.deleteCategory(category));
	}
	@Ignore
	@Test
	public void updateCategory()
	{
		Category category=categoryDao.getCategory(1);
		category.setCategoryname("NewEngine");
		category.setCategorydescription("New Engine Parts");
		assertEquals("Category updation failed",true,categoryDao.updateCategory(category));
	}
	@Ignore
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDao.getCategories();
		assertEquals("Problem in listing categories from database",listCategories.size());
		for(Category category:listCategories)
		{
			System.out.println(category.getCategoryid()+ "  ");
			System.out.println(category.getCategoryname()+ "  ");
			System.out.println(category.getCategorydescription());
		}
	}
	
}
