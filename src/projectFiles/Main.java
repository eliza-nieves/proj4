package projectFiles;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("PrimaryStage.fxml"));
        primaryStage.setTitle("Pizza Order");
        primaryStage.setScene(new Scene(root, 450, 650));
        primaryStage.show();
        primaryStage.setResizable(false);




    }


    public static void main(String[] args) {
        launch(args);
    }
}
