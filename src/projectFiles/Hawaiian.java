package projectFiles;

import java.util.Collections;
import java.util.ArrayList;

public class Hawaiian extends Pizza{
	//members: String style
	// String size
	// ArrayList<String> toppings
	private int basePrice = 8;
	
	public Hawaiian(String style, String size) {
		super(style, size);
		this.toppings = new ArrayList<String>(2);
		Collections.addAll(this.toppings, "Ham","Pineapple");
	}

	@Override
	public int pizzaPrice() {
		int res = basePrice;
		if(this.style.equals("Medium")) {
			res += mediumIncrement;
		}else if(this.style.equals("Large")) {
			res += largeIncrement;
		}
		return res;
	}
	
	public String toString() {
		String res = super.toString();
		res = res + " Price: $" + this.pizzaPrice();
		return res;
	}
	
}