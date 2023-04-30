package main.cart;

import java.util.HashMap;
import java.util.Map;
import main.exception.*;

public class ShoppingCart implements Cart{
	Map<Integer,CartItem> cartMap;
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
		cartMap = new HashMap<>();
	}
	@Override
	public void addItem(int id, CartItem item) {
		// TODO Auto-generated method stub
		cartMap.put(id, item);
		
	}

	@Override
	public void removeItem(int id) throws NoProductFoundException {
		// TODO Auto-generated method stub
		if(cartMap.containsKey(id)) {
			cartMap.remove(id);
		}else {
			throw new NoProductFoundException();
		}
	}

	@Override
	public void modifyItem(int id, int quantity) throws NoProductFoundException {
		// TODO Auto-generated method stub
		if(cartMap.containsKey(id)) {
			cartMap.get(id).setQuantity(quantity);
		}else {
			throw  new NoProductFoundException();
		}
	}
	public Map<Integer,CartItem> getCartMap(){
		return cartMap;
	}
}
