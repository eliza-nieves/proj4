package projectFiles;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class Controller {

    @FXML
    private ListView names;

    public void initialize(){
        names.getItems().addAll("Beef", "Cheese", "Chicken","Green Pepper", "Ham",
                "Mushroom", "Onion", "Pepperoni", "Pineapple", "Sausage");
        names.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
