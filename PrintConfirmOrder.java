package Spartan;

import BasicIO.*;

public class PrintConfirmOrder {
	
	private ReportPrinter report;
	
	/*
	 * Sets up the order confirmation
	 */
	public PrintConfirmOrder() {
		report = new ReportPrinter();
		report.addField("q", "Quantity", 10);  //Name of header, header name, # of characters allowed
		report.addField("i", "Item # ", 7);
		report.addField("d", "Description",  40);  //Name of header, header name, get percentage value, # of characters allowed
	}
	
	/**
	 * This method writes the confirmation details of the order
	 * @param s - the items thats been shipped
	 * @param size - the size of order
	 * @param day - the day it was shipped
	 * @param month - the month it was shipped
	 */
	public void writeDetails(ShipItems s, int size, int day, String month) {
		report.setTitle("Order Confirmation", "Order: " + s.getOrderNum(), "Customer #: " + s.getUserName(), "Name: " + s.getName(), "Address: " + s.getStName());
		for (int i = 0; i < size; i++) {
			if (s.getQuantity(i) == null) break;
			report.writeString("q", s.getQuantity(i));
			report.writeString("i", s.getID(i));
			report.writeString("d", s.getDescription(i));
		}
		report.writeString("d", "Your Order Shipped On: " + day + "-" + month + "-2018");
	}
	
	/*
	 * closes the report
	 */
	public void close() {
		report.close();
	}

}
