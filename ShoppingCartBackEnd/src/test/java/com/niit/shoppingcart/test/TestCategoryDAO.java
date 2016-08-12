package com.niit.shoppingcart.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;


public class TestCategoryDAO {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/

	@Autowired
	static CategoryDAO categoryDAO;
	
	@Autowired
	static Category category;
	
	
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		category = (Category) context.getBean("category");
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	
		
	}
	
	@Test
	public void CategoryNameTest()
	{
		category = categoryDAO.get("CG121");
		String name= category.getName();
         assertEquals("category Name test case","CGName121",name);
		
	}
}
