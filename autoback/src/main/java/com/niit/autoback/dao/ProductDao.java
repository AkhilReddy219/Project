package com.niit.autoback.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.autoback.model.Products;

public interface ProductDao 
{
	public boolean addProduct(Products product);
	public boolean updateProduct(Products product);
	public boolean deleteProduct(Products product);
	public Products getProduct(int productid);
	public List<Products> list();
	public List<Products> listProductByCategoryId(int categoryid);
}
