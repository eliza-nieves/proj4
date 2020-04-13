package projectFiles;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.ArrayList;

/*
import java.net.URL;
import java.util.ArrayList;
import java.applet.Applet;
*/

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class PrimaryController {
	
    @FXML
    private ComboBox<String> pizzaType; //Deluxe, Hawaiian, BYO
    
    @FXML
    private ComboBox<String> size; //set pizza size
    
    @FXML
    private ImageView img;
    
    @FXML
    private ListView<String> names; //all toppings
    
    @FXML
    private ListView<String> names1; //selected toppings
    
    @FXML
    private Button addBtn; //add selected toppings
    
    @FXML
    private Button rmvBtn; //remove selected toppings
    
    @FXML
    private Button clrBtn; //clear selection
    
    @FXML
    private Button addToOrder; //add pizza
    
    @FXML
    private Button viewOrder; //go to secondary stage
    
    @FXML
    private TextArea result; //TextArea at bottom of window
    
    
    private String[] allTops = {"Beef", "Cheese", "Chicken","Green Pepper", "Ham",
                "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage"};
    
    private static int GROW_SIZE = 4;
    
    public static Pizza[] order = new Pizza[GROW_SIZE];
    
    private int length = 0;
 

    public void initialize(){
        names.getItems().addAll(allTops);
        names.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        names1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
    public void selectPizzaType(ActionEvent event) {
    	String pizzaSize = (String) size.getValue();
    	String type = (String) pizzaType.getValue();
    	
    	if(type.equals("Deluxe")) {
    		names1.getItems().clear();
    		names.getItems().clear();
    		
    		Deluxe del = new Deluxe(type,pizzaSize);
    		String[] deluxeTops = {"Sausage","Pepperoni","Grenn Pepper","Onion","Mushroom"};
    		names1.getItems().addAll(deluxeTops);
    		
    		/*URL url = new URL(getCodeBase(),"../photos/Deluxe.jpg");
    		Image imageD = new Image(url);
    		img.setImage(imageD);*/
    		
    		addBtn.setDisable(true);
    		addBtn.setOpacity(.3);
    		rmvBtn.setDisable(true);
    		rmvBtn.setOpacity(.3);
    		clrBtn.setDisable(true);
    		clrBtn.setOpacity(.3);
    	}else if(type.equals("Hawaiian")) {
    		names1.getItems().clear();
    		names.getItems().clear();
    		
    		Hawaiian haw = new Hawaiian(type,pizzaSize);
    		String[] hawaiianTops = {"Ham","Pineapple"};
    		names1.getItems().addAll(hawaiianTops);
    		
    		/*Image imageD = new Image("@../photos/Hawaiian.jpg");
    		img.setImage(imageD);*/
    		
    		addBtn.setDisable(true);
    		addBtn.setOpacity(.3);
    		rmvBtn.setDisable(true);
    		rmvBtn.setOpacity(.3);
    		clrBtn.setDisable(true);
    		clrBtn.setOpacity(.3);
    		
    	}else {
    		names1.getItems().clear();
    		names.getItems().addAll(allTops);
    		
    		/*Image imageD = new Image("@../photos/Build%20Your%20Own.jpg");
    		img.setImage(imageD);*/
    		addBtn.setDisable(false);
    		addBtn.setOpacity(1);
    		rmvBtn.setDisable(false);
    		rmvBtn.setOpacity(1);
    		clrBtn.setDisable(false);
    		clrBtn.setOpacity(1);
    	}
    	
    }
    
    public void addBtnPress(ActionEvent event) {
    	ObservableList<Integer> selected = names.getSelectionModel().getSelectedIndices();
    	ObservableList<String> selectedVals = names.getSelectionModel().getSelectedItems();
    	int currSize = names1.getItems().size();
    	int limit = 6;
    	
    	if(currSize + selectedVals.size() > limit) {
    		result.appendText("Can not add more than 6 items.\n");
    		return;
    	}
    	
    	int len = selected.size();
    	if(len == 0) {
    		result.appendText("Please select items to add.\n");
    		return;
    	}
    	for(int i = 0; i < len; i ++) {
    		//retrieve value to add from names, add to names1
    		names1.getItems().add(names.getItems().get(selected.get(i))); 
    		
    	}
    	names.getItems().removeAll(selectedVals);
    	
    }
    
    public void rmvBtnPress(ActionEvent event) {
    	ObservableList<Integer> selected = names1.getSelectionModel().getSelectedIndices();
    	ObservableList<String> selectedVals = names1.getSelectionModel().getSelectedItems();
    	int len = selected.size();
    	if(len == 0) {
    		result.appendText("Please select items to remove.\n");
    		return;
    	}
    	for(int i = 0; i < len; i ++) {
    		names.getItems().add(names1.getItems().get(selected.get(i)));
    		
    	}
    	names1.getItems().removeAll(selectedVals);
    }
    
    public void clrBtnPress(ActionEvent event) {
    	names.getItems().clear();
    	names1.getItems().clear();
    	names.getItems().addAll(allTops);
    }
    
    /*
    public void viewOrder(ActionEvent event) {
    	Parent root = FXMLLoader.load(getClass().getResource("SecondaryStage.fxml"));
        secondaryStage.setTitle("Pizza Order");
        secondaryStage.setScene(new Scene(root, 450, 650));
        secondaryStage.show();
        secondaryStage.setResizable(false);
    }
    */
    
    public void viewOrderBtn(ActionEvent event) {
    	Parent root;
    	try {
            root = FXMLLoader.load(getClass().getResource("SecondaryStage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Current Order");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void addToOrderPress(ActionEvent event) {
    	String pizzaSize = (String) size.getValue();
    	String type = (String) pizzaType.getValue();
    	if(type.equals("Deluxe")) {
    		Deluxe temp = new Deluxe(type,pizzaSize);
    		add(temp);
    	}else if(type.equals("Hawaiian")) {
    		Hawaiian temp =new Hawaiian(type,pizzaSize);
    		add(temp);
    	}else {
    		ObservableList<String> selected = names1.getItems();
    		ArrayList<String> tempArr = new ArrayList<String>(selected);
    		int len = tempArr.size();
    		BuildYourOwn temp;
    		if(len == 0) {
    			temp = new BuildYourOwn(type,pizzaSize); 
    		}else {
    			System.out.println(tempArr.toString());
    			temp = new BuildYourOwn(type,pizzaSize,tempArr);
    		}
    		add(temp);
    	}
    	result.appendText("--Current Order--\n");
    	for(int i = 0; i < length; i ++) {
    		result.appendText(order[i].toString() + "\n");
    	}
    	result.appendText("\n");
    }
    
    
    private void add(Pizza temp) {
    	length++;
    	if(length >= order.length) {
    		order = grow(order);
    	}
    	order[length-1] = temp;
    }
    
    private Pizza[] grow(Pizza[] og) {
    	Pizza[] temp = new Pizza[length + GROW_SIZE];	
        System.arraycopy(og,0,temp,0,og.length);

        return temp;
    }

}
