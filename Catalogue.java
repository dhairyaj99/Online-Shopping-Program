package Spartan;

public interface Catalogue {
	
	/*
	 * This method will return the Catalogue Number
	 * @return string - the catalog Number
	 */
	public String getCatNum(int num);
	
	/**
	 * This method will return the price of a item
	 * @return double - the price of an item
	 */
	public double getPrice(int num);
	
	/**
	 * this method will return the description of a item
	 * @return string - the description of a item
	 */
	public String getDescription(int num);
	
	/**
	 * this method will get the number of items in the store
	 * @return the number of items - a integer
	 */
	public int getNumOfItems();

}
