package Spartan;

import BasicIO.*;
import java.util.*;

/**
 * This is the class that runs the shipment confirmation.  The user is greeted with a form that displays 
 * the products being shipped
 * @author James Zhao (6240527)
 * Version 1.0 (Mar 6, 2018)
 */

public class ConfirmOrder {
	
	private ASCIIDataFile file;
	private PrintConfirmOrder print;
	private ShipItems ship;
	private ShippingForm f;
	
	public ConfirmOrder() {
		file = new ASCIIDataFile();
		int count = 50;
		String months[] = {"Jan", "Feb", "Mar", "Apr", "Ma", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
		Random ran = new Random();
		
		ship = new ShipItems(file, count);  //Loading the file
		
		f = new ShippingForm(ship);
		
		
		int day = ran.nextInt(30)+1;
		
		//Display the form for the order
		if (f.confirm()) {
			f.close();
			print = new PrintConfirmOrder();
			print.writeDetails(ship, count, day, months[ran.nextInt(11)+1]);  //Gets a random date of when a product have shipped
			print.close();
		}
		
	}

	public static void main(String[] args) {ConfirmOrder s = new ConfirmOrder();} {
		// TODO Auto-generated method stub

	}

}
