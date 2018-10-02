package Spartan;

import BasicIO.*;

public class CatalogueImpl implements Catalogue{
	
	String catNum[];
	double price[];
	String desc[];
	int count;
	
	public CatalogueImpl(ASCIIDataFile from, int size) {
		catNum = new String[size];
		price = new double[size];
		desc = new String[size];
		count = 0;
		//Loads the Catalogue
		for (int i = 0; i < size; i++) {
			catNum[i] = from.readString();
			price[i] = from.readDouble();
			desc[i] = from.readString();
			count++;
		}
		
	}
	
	public int getNumOfItems() {
		return count;
	}
	
	@Override
	public String getCatNum(int num) {
		// TODO Auto-generated method stub
		return catNum[num];
	}

	@Override
	public double getPrice(int num) {
		// TODO Auto-generated method stub
		return price[num];
	}

	@Override
	public String getDescription(int num) {
		// TODO Auto-generated method stub
		return desc[num];
	}
	

}
