package jberlin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Created by john on 11/11/15.
 */
public class EnterFileControler {
    @FXML private TextField enterFName;
    @FXML private TextField enterExt;
    @FXML private TextField enterData;
    @FXML private Button doneButton;
    private GridPane widow;

    public EnterFileControler(EventHandler<ActionEvent> value){
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("enterFileInfo.fxml"));
        loader.setController(this);
        try {
            widow = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        doneButton.setOnAction(value);
    }

    public GridPane getWidow(){
        return widow;
    }

}
