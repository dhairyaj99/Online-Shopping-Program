package Spartan;

public interface Cart {
	
	/**
	 * This method gets the catalog number
	 * @return catalog number - a String
	 */
	public String getCatNum();
	
	/**
	 * this method gets the quantity of a product
	 * @return quantity - a integer
	 */
	public int getQuantity();
	
	/**
	 * this method gets the price of a product
	 * @return price - a Double
	 */
	public double getPrice();
	
	/**
	 * this method gets the description of a product
	 * @return description - a String
	 */
	public String getDesc();
	
	/**
	 * This method sets the number of same products a customer wants to buy
	 * @param n - stands for new quantity
	 */
	public void setQuantity(int n);

}
