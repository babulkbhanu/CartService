package main.cart;

import java.util.Map;

import main.exception.NoProductFoundException;

public interface Cart{
	public void addItem(int id, CartItem item );
	public void removeItem(int id) throws NoProductFoundException;
	public void modifyItem(int id, int quantity) throws NoProductFoundException;
	public Map<Integer,CartItem> getCartMap();
	
}
