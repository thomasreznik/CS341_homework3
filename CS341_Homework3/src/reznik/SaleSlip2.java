package reznik;

import java.util.ArrayList;

public class SaleSlip2 {

	public String salestring = "";
	public ArrayList<String> item;
	public ArrayList<Double> cost;
	public ArrayList<Integer> quantity;

	public SaleSlip2() {
		item = new ArrayList<String>();
		cost = new ArrayList<Double>();
		quantity = new ArrayList<Integer>();
	}

	public void insert_slip(String j, Double k, int z) {
		item.add(j);
		cost.add(k);
		quantity.add(z);

	}
 //Calculation of the sum of the sales report 
	public String Total() {

		double sum = 0;

		for (int i = 0; i < cost.size(); i++) {

			sum = sum + (cost.get(i) * quantity.get(i));

		}

		String endTotal = "$: " + Math.round(sum * 100.0) / 100.0;
		return endTotal;

	}
//How the String gets displayed
	public String display() {
		salestring = salestring + "Item: " + item.get(item.size() - 1) + "   Cost: " + cost.get(cost.size() - 1)
				+ "   Quantity: " + quantity.get(quantity.size() - 1) + "\n";
		return salestring;

	}
}