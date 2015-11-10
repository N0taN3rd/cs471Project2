package jberlin;


import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Directory extends TreeItem<String> {
    private String dName;
    public Directory(String dName, Inode... children) {
        super("Directory: "+dName);
        this.dName = dName;
        this.getChildren().addAll(children);
    }



}
