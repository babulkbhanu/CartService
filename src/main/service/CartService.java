package main.service;

import main.cart.Cart;
import main.cart.CartItem;
import main.cart.ShoppingCart;
import main.enums.OfferEnum;
import main.exception.NoProductFoundException;
import main.offers.Offer;
import main.offers.OnePlusOneOffer;
import main.product.Product;

import java.util.*;

// this is a service layer with which the clien will interact
public class CartService {
 private Cart cart;
 private Map<Integer,Double> priceMap;
 private Map<Integer,Double> discountMap;
 private Map<Integer,Offer> offerMap;

 public CartService(){
	 //here i can define factory of carts;
	 cart = new ShoppingCart();
	 discountMap = new HashMap();
	 offerMap = new HashMap();
	 priceMap = new HashMap<>();
 }
 
 
 public void init() {
	 this.priceMap.put(1,20d);
	 this.priceMap.put(2,50d);
	 this.priceMap.put(3,10d);
	 this.priceMap.put(4,16d);
	 this.priceMap.put(5,100d);
	 
	 this.discountMap.put(5,50d);
	 
	 //init offer
	 this.offerMap.put(1, new OnePlusOneOffer());
	 this.offerMap.put(5, new OnePlusOneOffer());
	 
 }
 
 
 public void addItem(String name ,int id, int quantity) {
	 if(!priceMap.containsKey(id)) return;
	 Product item = new Product(name, id, priceMap.get(id));
	 CartItem cartItem =new CartItem(item,quantity);
	 cart.addItem(id, cartItem);
 }
 
 public void removeItem(int id) throws NoProductFoundException {
	 this.cart.removeItem(id);
 }
 
 public void modifyItem(int id,int quantity) throws NoProductFoundException {
	 this.cart.modifyItem(id, quantity);
 }
 
 public double calculatePrice() {
	 
	 double finalPrice = 0;
	 for(int key:this.cart.getCartMap().keySet()) {
		 double thisItemPrice = 0;
		 CartItem item = this.cart.getCartMap().get(key);
		 Offer offer = this.offerMap.getOrDefault(key,null);
		 double discount = this.discountMap.getOrDefault(key, 0d);
		 if(offer!=null && offer.validate()) {
			 thisItemPrice+=offer.apply(item);
		 }else {
			 thisItemPrice = priceMap.get(key);
		 }
		 thisItemPrice -= (discount*thisItemPrice)/100;
		 
		 finalPrice+=thisItemPrice;
	 } 
	 return finalPrice;
 }
}
