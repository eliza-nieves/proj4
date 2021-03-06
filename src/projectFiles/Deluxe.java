package projectFiles;

import java.util.Collections;
import java.util.ArrayList;

/**
 * @author Eliza Nieves
 * @author Raheel Ozair
 */
public class Deluxe extends Pizza{
	//members: String style
	// String size
	// ArrayList<String> toppings
	private int basePrice = 14;

	public Deluxe(String style, String size) {
		super(style, size);
		this.toppings = new ArrayList<String>(5);
		Collections.addAll(this.toppings, "Sausage","Pepperoni","Grenn Pepper","Onion","Mushroom");
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