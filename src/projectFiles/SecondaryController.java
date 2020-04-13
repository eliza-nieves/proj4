package projectFiles;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SecondaryController {
	
	@FXML
	TextArea orderBox;
	
	@FXML
	TextField priceBox;
	
	@FXML
	Button clrBtn2;
	
	@FXML
	Button backBtn;
	
	public static Pizza[] currOrder = PrimaryController.order;
	public static int len = currOrder.length;
	
    public void initialize(){
    	if(currOrder[0] == null) {
    		orderBox.appendText("Order is empty.\n");
    	}else {
    		int orderTotal = 0;
    		for(int i = 0; i < len; i ++) {
    			if(currOrder[i] == null) {
    				break;
    			}else {
    				orderBox.appendText(currOrder[i].toString() + "\n");
    				orderTotal += currOrder[i].pizzaPrice();
    			}
    		}
    		priceBox.appendText("$" + orderTotal);
    	}
    }
    
    public void backBtnPress(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    public void clrBtnPress(ActionEvent event) {
    	for(int i = 0; i < len; i ++) {
    		PrimaryController.order[i] = null;
    		currOrder[i] = null;
    	}
    	orderBox.clear();
    	priceBox.clear();
    }

}
