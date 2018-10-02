package Spartan;

/**
 * This is a node class which will store the information of items that's
 * been added to the cart
 * @author James
 *
 */

class CartList {
	
	CartImpl item;
	CartList next;
	
	CartList(Cart i, CartList l) {
		item = (CartImpl) i;
		next = l;
	}

}
