package com.niit.shoppingcart.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserLoginDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.UserDetails;

public class TestSupplierDAO {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Cart cart;
	
	AnnotationConfigApplicationContext context;

	
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		cart = (Cart) context.getBean("cart");
		
	}
	
	@Test
	public void UsersTestCase()
	{
		int size = supplierDAO.listSupplier().size();
		
		assertEquals("supplier list test case",5,size);
		
	}

}
