package com.niit.shoppingcart.dao;

import java.util.List;



import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {

	void saveOrUpdate(Category category);
	
	void delete(String id);
	
	Category get(String id);
	
	public List<Category> listCategory();
}
