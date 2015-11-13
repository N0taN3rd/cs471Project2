package jberlin;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("vfs.fxml"));
        primaryStage.setTitle("John Berlin cs471 Project 2");
        primaryStage.setScene(new Scene(root, 1000,
                Screen.getPrimary().getVisualBounds().getHeight()/2));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
