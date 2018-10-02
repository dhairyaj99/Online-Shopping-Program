package Spartan;

import BasicIO.*;

public class AccountImpl implements Accounts {

	private String username[];
	private String password[];
	private String name[];
	private String stName[];
	private int count;
	
	public AccountImpl(ASCIIDataFile from, int size) {
		username = new String[size];
		password = new String[size];
		name = new String[size];
		stName = new String[size];
		count = 0;
		
		for (int i = 0; i < size; i++) {
			username[i] = from.readString();
			name[i] = from.readString();
			stName[i] = from.readString();
			password[i] = from.readString();
			count++;
		}
		
	}
	
	@Override
	public String getUsername(int num) {
		// TODO Auto-generated method stub
		return username[num];
	}

	@Override
	public String getPassword(int num) {
		// TODO Auto-generated method stub
		return password[num];
	}

	@Override
	public String getName(int num) {
		// TODO Auto-generated method stub
		return name[num];
	}

	@Override
	public String getStName(int num) {
		// TODO Auto-generated method stub
		return stName[num];
	}
	
	public int getNumAcc() {
		return count;
	}
	

}
