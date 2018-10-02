package Spartan;

import BasicIO.*;
import java.util.*;

/**
 * This is the class that runs the store.  The user will be greeted with a log in form followed by a list of items
 * The User can choose which item he/she would like to purchase.  Once done, the program will save there order
 * where the company will confirm that order.
 * @author Dhairya Jaiswal (6240527)
 * Version 1.0 (Mar 6, 2018)
 */

public class Spartan {
	
	private ASCIIDataFile file;
	private ShoppingForm shop;
	private LogOnForm acc;
	private Catalogue cata;
	private Accounts ac;
	
	public Spartan() {
		OrderConfirmation oC;
		int productNum;
		int numAcc;
		boolean online = false;  //Checks to see if the user entered the right information
		
		file = new ASCIIDataFile();
		
		productNum = file.readInt();
		cata = new CatalogueImpl(file, productNum);
		
		numAcc = file.readInt();
		ac = new AccountImpl(file,numAcc);
		
		acc = new LogOnForm(ac);
		
		for (; ;) {
			if (acc.confirm()) {
				acc.close();
				online = true;
				break;
			}
			acc.clear();
			acc.error();
		}
		
		if (online) {
			shop = new ShoppingForm(cata);
			for (; ;) {
				if (shop.confirm()) {
					shop.close();
					break;
				}
			}
		}
		
		Random ran = new Random();
		int orderNum = ran.nextInt(1000) + 1;  //Get order number
		
		//Saving the order
		oC = new OrderConfirmation();
		oC.writeDetails(orderNum, ac, shop, acc);
		oC.orderConfirmation(orderNum, ac, shop, acc);
		oC.close();
	}
	
	

	public static void main(String[] args) {Spartan s = new Spartan();} {
		// TODO Auto-generated method stub

	}

}
