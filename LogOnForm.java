package Spartan;

import BasicIO.*;

class LogOnForm {
	
	private BasicForm form;
	private Accounts acc;
	private int index;
	
	//Sets up the display
	public LogOnForm(Accounts a) {
		form = new BasicForm();
		acc = a;
		form.addTextField("u", "Username: ", 12, 5, 10);
		form.addTextField("p", "Password: ", 12, 5, 40);
		form.addTextField("m", "Message: ", 35, 5, 70);
		form.setEditable("m", false);
	}
	
	//Allows the form to be usable
	public boolean confirm() {
		int button = form.accept("Log In", "Quit");
		
		if (button == 0) {
			for (int i = 0; i < acc.getNumAcc(); i++) {
				if (form.readString("u").equals(acc.getUsername(i))   && form.readString("p").equals(acc.getPassword(i))) {
					index = i;
					return true;
				}
			}
		} else {
			close();
		}
		return false;
	}
	
	/**
	 * gets the index value
	 * @return index value
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * This method displays an error message when the user enters the wrong information
	 */
	public void error() {
		form.writeString("m", "Invalid Username/Password");
	}
	/*
	 * clears the form
	 */
	public void clear() {
		form.clearAll();
	}
	
	/*
	 * closes the form
	 */
	public void close() {
		form.close();
	}
	

}
