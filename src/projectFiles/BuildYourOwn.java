package projectFiles;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Eliza Nieves
 * @author Raheel Ozair
 */
public class BuildYourOwn extends Pizza{
	//members: String style
	// String size
	// ArrayList<String> toppings
	private int basePrice = 5;
	private int perTopping = 2;

	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
	}
	public BuildYourOwn(String style, String size) {
		super(style,size);
	}

	@Override
	public int pizzaPrice() {
		int res;
		if(this.toppings == null) {
			res = basePrice;
		}else {
			int numTops = toppings.size();
			res = basePrice + (perTopping * numTops);
		}
		
		if(size.equals("Medium")){
			res += mediumIncrement;
		}else if(size.equals("Large")) {
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