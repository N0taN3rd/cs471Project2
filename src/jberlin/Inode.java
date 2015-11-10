package jberlin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Inode extends TreeItem<String> {
    private ObservableList<TreeItem<String>> childern;

    public Inode(String fileName, String ext, String data) {
        super(fileName+"."+ext);
        this.childern = FXCollections.observableArrayList(
                new TreeItem<>("File Name: "+fileName),new TreeItem<>("File type: "+ext),
                new TreeItem<>("Data: "+data)
        );
        this.getChildren().addAll(childern);
    }

}
