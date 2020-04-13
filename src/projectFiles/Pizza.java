package projectFiles;

import java.util.ArrayList;

public abstract class Pizza {
	protected String style;
	protected String size;
	protected ArrayList<String> toppings = null;
	protected int mediumIncrement = 2;
	protected int largeIncrement = 4;
	public Pizza(String style, String size, ArrayList<String> toppings) {
		this.style = style;
		this.size = size;
		this.toppings = new ArrayList<String>(6);
		this.toppings.addAll(toppings);
	}
	public Pizza(String style, String size) {
		this.style = style;
		this.size = size;
	}
	
	public abstract int pizzaPrice();
	
	public String toString() {
		String ret;
		if(this.toppings == null) {
			ret = this.size + " " + this.style + ". Toppings: None.";
		}else {
			ret = this.size + " " + this.style + ". Toppings: " + this.toppings.toString();
		}
		return ret;
	}
}