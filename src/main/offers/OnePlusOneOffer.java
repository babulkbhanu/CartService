package main.offers;

import main.cart.CartItem;

public class OnePlusOneOffer implements Offer {

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double apply(CartItem cartItem) {
		// TODO Auto-generated method stub
		
		double perUnitPrice = cartItem.getItem().getPerUnitCost();
		int quantity = cartItem.getQuantity();
		return (perUnitPrice * (quantity/2)) + (perUnitPrice * (quantity%2));
	}

}
