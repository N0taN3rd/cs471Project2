package jberlin;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by jberlin on 11/12/2015.
 */
public class NewFileControler {
    @FXML private TextField eFName;
    @FXML private TextField eFExt;
    @FXML private TextField eFData;
    @FXML private Button done;
    private GridPane window;
    private  Stage stage;
    public NewFileControler(){
        URL url = this.getClass().getClassLoader().getResource("enterFileInfo.fxml");
        if(url == null)
            url = this.getClass().getResource("enterFileInfo.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        loader.setController(this);
        try {
            window = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = new Stage();
        stage.setScene(new Scene(window));
        this.done.setOnAction(doneAction-> stage.close());
    }

    public void openStage(){
        stage.showAndWait();
    }


    public GridPane getWindow(){
        return this.window;
    }


    public boolean isGoodInfo(){
        boolean good = true;
        if(eFName.getText().equals("") || eFName.getText().isEmpty())
            good = false;

        if(eFExt.getText().equals("") || eFExt.getText().isEmpty())
            good = false;

        if(eFData.getText().equals("") || eFData.getText().isEmpty())
            good = false;

        return good;
    }
    public String[] getInfo(){
        String[] info = new String[]{eFName.getText().trim(),eFExt.getText().trim(),eFData.getText().trim()};
        this.eFData.clear();
        this.eFExt.clear();
        this.eFName.clear();
        return info;
    }
}
