package jberlin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Created by john on 11/11/15.
 */
public class VSF extends TreeItem<String> {
    public VSF(String name, Vnode... nodes){
        super(name);
        ObservableList<TreeItem<String>> childern = FXCollections.observableArrayList();
        for(Vnode n : nodes){
            childern.addAll(n.getChildren());
        }
        this.getChildren().addAll(childern);
    }
}
