package Spartan;

import BasicIO.*;

public class ShipItems {
	
	private String quant[];
	private String ID[];
	private String desc[];

	private String orderNum;
	private String userName;
	private String name;
	private String stName;
	
	public ShipItems(ASCIIDataFile from, int size) {
		quant = new String[size];
		ID = new String[size];
		desc = new String[size];
		
		orderNum = from.readString();
		userName = from.readString();
		name = from.readString();
		stName = from.readString();
		int count = 0;
		
		for (; ;) {
			if (from.isEOF()) break;
			quant[count] = from.readString();
			ID[count] = from.readString();
			desc[count] = from.readString();
			count++;
		}
	}
	
	public String getOrderNum() {
		return orderNum;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getStName() {
		return stName;
	}
	
	public String getQuantity(int num) {
		return quant[num];
	}
	
	public String getID(int num) {
		return ID[num];
	}
	
	public String getDescription(int num) {
		return desc[num];
	}
	
	public int getSize() {
		return desc.length;
	}

}
