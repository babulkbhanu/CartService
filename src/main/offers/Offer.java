package main.offers;

import main.cart.CartItem;

public interface Offer {
	public boolean validate();
	public double apply(CartItem cartItem);
}
