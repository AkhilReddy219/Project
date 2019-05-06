package com.niit.autoback.dao;

import java.util.List;

import com.niit.autoback.model.CartItems;

public interface CartDao {
		public boolean addCartItem(CartItems cartitem);
		public boolean deleteCartItem(CartItems cartitem);
		public boolean updateCartItem(CartItems cartitem);
		public CartItems getCartItems(int cartitemid);
		public List<CartItems> listCartItems(String username);
}
