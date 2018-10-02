package Spartan;

import BasicIO.*;

class ShippingForm {
	
	private BasicForm form;
	private ShipItems ship;
	
	public ShippingForm(ShipItems s) {
		ship = s;
		form = new BasicForm();
		form.addTextField("o", "Order Number", 5, 10, 10);
		form.setEditable("o", false);
		form.addTextArea("c", "Cart", 20, 50, 10, 45);
	}
	
	//Allows the form to become usable
	public boolean confirm() {
		int button;
		
		fillForm();
		button = form.accept("Ship", "Quit");
		
		if (button == 0) {
			return true;
		} else {
			close();
		}
		
		return false;
	}
	
	/*
	 * fill in the details of a form
	 */
	public void fillForm() {
		form.writeString("o", ship.getOrderNum());
		
		for (int i = 0; i < ship.getSize(); i++) {
			if (ship.getQuantity(i) == null) break;
			form.writeString("c", ship.getQuantity(i));
			form.writeString("c", ship.getID(i));
			form.writeString("c", ship.getDescription(i));
			form.newLine("c");
		}
		
	}
	
	public void close() {
		form.close();
	}

}
