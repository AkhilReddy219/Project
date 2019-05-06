package com.niit.autoback.dao;

import java.util.List;

import com.niit.autoback.model.Category;

public interface CategoryDao {

		public boolean insertCategory(Category category);
		public boolean updateCategory(Category category);
		public boolean deleteCategory(Category category);
		public Category getCategory(int categoryid);
		public List<Category>getCategories();
}
