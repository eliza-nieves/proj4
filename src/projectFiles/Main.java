package projectFiles;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Pizza Order");
        primaryStage.setScene(new Scene(root, 450, 650));
        primaryStage.show();
        primaryStage.setResizable(false);




    }


    public static void main(String[] args) {
        launch(args);
    }
}
