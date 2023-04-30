package main;

import main.exception.NoProductFoundException;
import main.service.CartService;

public class BasketPriceCalculator {

	public static void main(String args[]) {
		CartService s1 = new CartService();
		s1.init();
		s1.addItem("Apple",1,3);
		s1.addItem("Banana",5,5);
		try {
			s1.modifyItem(5, 7);
			s1.removeItem(1);
		}
		catch(NoProductFoundException e) {
			System.out.println("NO SUCH PRODUCT IN THE CART");
		}
		
		System.out.println(s1.calculatePrice());
	}
}
