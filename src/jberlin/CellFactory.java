package jberlin;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;

/**
 * Created by john on 11/11/15.
 */
public class CellFactory {

    public static TreeCell<String> makeCell(){
        TextFieldTreeCell<String> cell  =  new TextFieldTreeCell<>();
        cell.setEditable(false);
        ContextMenu cm = new ContextMenu();
        MenuItem add = new MenuItem("Add");
        add.setOnAction(action -> {
            TreeItem<String> item = cell.getTreeItem();
            if(item instanceof Inode) {
                System.out.println("Its an Inode");
                // item.getParent().getChildren().remove(item);
            } else if(item instanceof Vnode) {
                System.out.println("Its a Vnode");
            } else if(item instanceof Directory) {
                System.out.println("Its a directory");
                //item.getParent().getChildren().remove(item);
            } else {
                System.out.println("Its something else");
            }

        });
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(action -> {
            TreeItem<String> item = cell.getTreeItem();
            if(item instanceof Inode) {
                System.out.println("Its an Inode");
                item.getParent().getChildren().remove(item);
            } else if(item instanceof Vnode) {
                System.out.println("Its a Vnode");
            } else if(item instanceof Directory) {
                System.out.println("Its a directory");
                item.getParent().getChildren().remove(item);
            } else {
                System.out.println("Its something else");
            }

        });
        cm.getItems().add(add);
        cm.getItems().add(delete);

        cell.setContextMenu(cm);

        return cell;
    }

}
