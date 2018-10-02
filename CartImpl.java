package Spartan;

public class CartImpl implements Cart{
	
	private String catNum;
	private int quantity;
	private double price;
	private String description;
	
	public CartImpl(String c, int q, double p, String d) {
		catNum = c;
		quantity = q;
		price = p;
		description = d;
	}

	@Override
	public String getCatNum() {
		// TODO Auto-generated method stub
		return catNum;
	}

	@Override
	public int getQuantity() {
		// TODO Auto-generated method stub
		return quantity;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}
	
	public void setCatNum(String c) {
		catNum = c;
	}
	
	public void setQuantity(int n) {
		quantity = n;
	}
	
	public String getDesc() {
		// TODO Auto-generated method stub
		return description;
	}
	
	public double calTot() {
		double total = quantity * price;
		return total;
	}
	
	

}
