package Spartan;

import static BasicIO.Formats.*;
import BasicIO.*;

public class OrderConfirmation {
	
	private ReportPrinter report;
	private ASCIIOutputFile output;
	private CartList list;
	
	public OrderConfirmation() {
		report = new ReportPrinter();
		report.addField("q", "Quantity", 10);  //Name of header, header name, # of characters allowed
		report.addField("i", "Item # ", 7);
		report.addField("d", "Description",  25);  //Name of header, header name, get percentage value, # of characters allowed
		//Name of header, header name, set value to two decimal places, # of characters allowed
		report.addField("a", "Amount", getCurrencyInstance(), 10);  
		report.addField("t", "Total", getCurrencyInstance(),  10);
	}
	
	public void writeDetails(int orderNum, Accounts a, ShoppingForm s, LogOnForm l) {
		list = s.getList();
		double tot = 0;
		report.setTitle("Order Confirmation", "Order: " + orderNum, "Customer #: " + a.getUsername(l.getIndex()), "Name: " + a.getName(l.getIndex()), "Address: " + a.getStName(l.getIndex()));
		
		while (list != null) {
			report.writeInt("q", list.item.getQuantity());
			report.writeString("i", list.item.getCatNum());
			report.writeString("d", list.item.getDesc());
			report.writeDouble("a", list.item.getPrice());
			report.writeDouble("t", list.item.calTot());
			tot += list.item.calTot();
			list = list.next;
		}
		report.writeString("d", "Total");
		report.writeDouble("t", tot);
		
	}
	
	/**
	 * Writes out the order into a asciidata file which would be used for later
	 * @param orderNum - the order number for his order
	 * @param a - stands for accounts
	 * @param s - shoppingform information
	 * @param l - log in form information
	 */
	public void orderConfirmation(int orderNum, Accounts a, ShoppingForm s, LogOnForm l) {
		output = new ASCIIOutputFile();
		output.writeInt(orderNum);
		output.writeString(a.getUsername(l.getIndex()));
		output.writeString(a.getName(l.getIndex()));
		output.writeString(a.getStName(l.getIndex()));
		
		list = s.getList();
		
		while (list != null) {
			output.writeInt(list.item.getQuantity());
			output.writeString(list.item.getCatNum());
			output.writeString(list.item.getDesc());
			list = list.next;
		}
		
	}
	
	public void close() {
		report.close();
		output.close();
	}

}
