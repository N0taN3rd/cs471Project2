package jberlin;


import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Directory extends TreeItem<Inode> {
    private StringProperty dName;
    private Vnode parent;
    private ObservableList<Inode> children;

}
