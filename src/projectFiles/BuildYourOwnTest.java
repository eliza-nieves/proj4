package projectFiles;

import org.junit.Assert;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * @author Eliza Nieves
 * @author Raheel Ozair
 */
public class BuildYourOwnTest {

    @org.junit.Test
    public void pizzaPrice() {
        ArrayList<String> oneTopping = new ArrayList<String>();
        oneTopping.add("Pepperoni");

        ArrayList<String> threeToppings = new ArrayList<String>();
        threeToppings.add("Pepperoni");
        threeToppings.add("Sausage");
        threeToppings.add("Cheese");

        ArrayList<String> sixToppings = new ArrayList<String>();
        sixToppings.add("Pepperoni");
        sixToppings.add("Sausage");
        sixToppings.add("Cheese");
        sixToppings.add("Pineapple");
        sixToppings.add("Peppers");
        sixToppings.add("Beef");

        //All cases: Small, medium, and large pizzas with either 1, 3 (1<3<6), or 6 toppings. Topping
        //values below 1 and above 6 were not tested because they are assumed to have been caught before this method.
        BuildYourOwn smallNoToppings = new BuildYourOwn("Build Your Own", "Small", oneTopping);
        BuildYourOwn smallThreeToppings = new BuildYourOwn("Build Your Own", "Small", threeToppings);
        BuildYourOwn smallSixToppings = new BuildYourOwn("Build Your Own", "Small", sixToppings);

        BuildYourOwn mediumNoToppings = new BuildYourOwn("Build Your Own", "Medium", oneTopping);
        BuildYourOwn mediumThreeToppings = new BuildYourOwn("Build Your Own", "Medium", threeToppings);
        BuildYourOwn mediumSixToppings = new BuildYourOwn("Build Your Own", "Medium", sixToppings);

        BuildYourOwn largeNoToppings = new BuildYourOwn("Build Your Own", "Large", oneTopping);
        BuildYourOwn largeThreeToppings = new BuildYourOwn("Build Your Own", "Large", threeToppings);
        BuildYourOwn largeSixToppings = new BuildYourOwn("Build Your Own", "Large", sixToppings);

        assertTrue(smallNoToppings.pizzaPrice() == 7);
        assertTrue(smallThreeToppings.pizzaPrice() == 11);
        assertTrue(smallSixToppings.pizzaPrice() == 17);
        assertTrue(mediumNoToppings.pizzaPrice() == 9);
        assertTrue(mediumThreeToppings.pizzaPrice() == 13);
        assertTrue(mediumSixToppings.pizzaPrice() == 19);
        assertTrue(largeNoToppings.pizzaPrice() == 11);
        assertTrue(largeThreeToppings.pizzaPrice() == 15);
        assertTrue(largeSixToppings.pizzaPrice() == 21);
    }
}