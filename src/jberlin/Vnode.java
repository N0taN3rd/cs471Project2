package jberlin;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Vnode extends TreeItem<String> {
    private String driveName;
    public Vnode(String driveName, Directory... directories){
        super("Drive: "+driveName);
        this.getChildren().addAll(directories);
    }
}
