package Spartan;

import static BasicIO.Formats.getCurrencyInstance;

import BasicIO.*;

class ShoppingForm {
	
	private BasicForm form;
	private Catalogue list;
	private Cart cart;
	private CartList items;  //The list of items the user will purchase
	private boolean state;  //This stands for adding or removing
	private boolean check;  //This checks if an item is already on the list or not
	
	/**
	 * Sets up the shopping form
	 * @param cata - help get the details of the products that will be displayed on the form
	 */
	public ShoppingForm(Catalogue cata) {
		form = new BasicForm();
		list = cata;
		form.addTextArea("c", "Catalogue", 20, 40, 10, 10);
		form.addTextArea("ca", "Cart", 20, 40, 330, 10);
		form.addTextField("i", "Item # ", 5, 10, 400);
		form.addTextField("q", "Quantity", 3, 100, 400);
		form.addTextField("o", "Order Total ",  getCurrencyInstance(), 10, 340, 400);
		form.setEditable("o", false);
	}
	
	/**
	 * Fill the Catalogue section of the form with all the products
	 * avaliable
	 */
	public void fillCatalogue() {
		form.clear("c");
		for (int i = 0; i < list.getNumOfItems(); i++) {
			form.writeString("c", list.getCatNum(i));
			form.writeDouble("c", list.getPrice(i));
			form.writeString("c", list.getDescription(i));
			form.newLine("c");
		}
	}
	
	/*
	 * This method fills in the detail for the cart section of the display
	 */
	public void fillCart() {
		CartList p = items;
		form.clear("ca");
		while (p != null) {
			form.writeInt("ca", p.item.getQuantity());
			form.writeDouble("ca", p.item.getPrice());
			form.writeString("ca", p.item.getCatNum());
			form.writeString("ca", p.item.getDesc());
			form.newLine("ca");
			p = p.next;
		}
		
	}
	
	
	public void clearTotal() {
		form.clear("o");
	}
	
	public void clearOrder() {
		form.clear("i");
		form.clear("q");
	}
	
	/**
	 * The operations of the form
	 * @return true if the user is done shopping
	 * @return false when none of the conditions are met
	 */
	public boolean confirm() {
		int button;
		fillCatalogue();
		
		button = form.accept("Add", "Remove", "Done");
		
		if (button == 0) {
			checkProduct();
			if (state) {
				addItemToCart();
				fillCart();
				calcTotal();
			}
		} else if (button == 1) {
			checkProduct();
			if (state) {
				removeItem();
				fillCart();
				calcTotal();
			}
		} else if (button == 2) {
			return true;
		}
		
		
		return false;
	}
	
	public void checkProduct() {
		state = false;
		int quantity = form.readInt("q");
		//The case where the user forgets to enter the quantity
		if (quantity == 0) {
			quantity++;
		}
		
		for (int i = 0; i < list.getNumOfItems(); i++) {	
			if (list.getCatNum(i).equals(form.readString("i"))) {
				cart = new CartImpl(list.getCatNum(i), quantity, list.getPrice(i), list.getDescription(i));
				state = true;
			}
		}
		clearOrder();
	}
	
	/*
	 * This method adds a product to the list and update existing products
	 */
	public void addItemToCart() {
		CartList p = items;
		CartList q = null;
		check = false;
		
		while (p != null) {
			q = p;
			if (q.item.getCatNum().equals(cart.getCatNum())) {
				check = true;
				break;
			}
			p = p.next;
		}
		
		if (!check) {
			//adds items to the cart
			if (q == null) {
				items = new CartList(cart, null);
			} else {
				q.next = new CartList(cart, null);
			}
		} else {
			q.item.setQuantity(cart.getQuantity() + q.item.getQuantity());  //Updates existing item on the cart
		}
		
		
	}
	/**
	 * This class removes a item from the cart
	 * Whether they be the quantity or the product itself
	 */
	public void removeItem() {
		CartList p = items;
		CartList q = null;
		
		while (p != null) {
			q = p;
			if (q.item.getCatNum().equals(cart.getCatNum())) {
				check = true;
				break;
			}
			p = p.next;
		}
		
		if (check) {	
			if (q.item.getQuantity() - cart.getQuantity() > 0) {
				q.item.setQuantity(q.item.getQuantity() - cart.getQuantity());
			} else {
				newList();
			}
		}
		
	}
	
	/**
	 * This method creates the new list
	 */
	public void newList() {
		CartList p = items;
		CartList q = null;
		
		while (p != null) {
			if (p.item.getCatNum().equals(cart.getCatNum())) {
				if (q == null) {
				items = p.next;
				} else {
					q.next = p.next;
				}
		} 
			q = p;
			p = p.next;		
		}
	}
	
	/**
	 * This method calculates the total price of the items you are purchasing
	 */
	public void calcTotal() {
		CartList p = items;
		double total = 0;
		
		while (p != null) {
			total += p.item.getPrice() * p.item.getQuantity();
			p = p.next;
		}
		
		clearTotal();
		form.writeDouble("o", total);
		
	}
	
	public CartList getList() {
		return items;
	}
	
	public void close() {
		form.close();
	}

}
