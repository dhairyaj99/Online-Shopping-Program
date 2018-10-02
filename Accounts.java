package Spartan;

public interface Accounts {

	/**
	 * This method intends to get an existing username in the system
	 * @param num - the index value
	 * @return username - a string
	 */
	public String getUsername(int num);
	
	/**
	 * This method intends to get an existing Password in the System
	 * @param num - the index location of password in the array
	 * @return password - a string
	 */
	public String getPassword(int num);
	
	/**
	 * This method intends to get an existing name of a customer
	 * @param num - the index location of the name in the array
	 * @return names - a string
	 */
	public String getName(int num);

	/**
	 * This method intends to get an existing address of a customer
	 * @param num - the index location of the address in the array
	 * @return address - a string
	 */
	public String getStName(int num);
	
	/**
	 * This method gets the number of accounts in the syste
	 * @return number of accounts - a integer value
	 */
	public int getNumAcc();
	
}
