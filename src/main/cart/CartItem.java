package main.cart;

import main.offers.Offer;
import main.product.Product;

public class CartItem {
	private Product item;
	public CartItem(Product item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	//private double discount;
	//private Offer offer;
	private int quantity;
	public Product getItem() {
		return item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setItem(Product item) {
		this.item = item;
	}	
	public double calculate() {
		
		return 0;
	}
}
