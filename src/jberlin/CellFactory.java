package jberlin;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.StringConverter;

import java.util.function.Consumer;

/**
 * Created by john on 11/11/15.
 */
public class CellFactory {

    public static TreeCell<String> makeCell(final Consumer<String> display){
        TextFieldTreeCell<String> cell  =  new MTreeCell(display);

        cell.setEditable(false);
        /*
        ContextMenu cm = new ContextMenu();
        MenuItem add = new MenuItem("Add");
        add.setOnAction(action -> {
            TreeItem<String> item = cell.getTreeItem();
            if(item instanceof Inode) {
                System.out.println("Its an Inode");
                // item.getParent().getChildren().remove(item);
            } else if(item instanceof Directory) {
                System.out.println("Its a directory");
                //item.getParent().getChildren().remove(item);
            }

        });
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(action -> {
            TreeItem<String> item = cell.getTreeItem();
            if(item instanceof Inode) {
                Inode inode = (Inode)item;
                inode.removeMe();
                display.accept("Removing File: "+inode.getFileNameType()+"\n Paths: VFS["+inode.getVFSPath()
                        +"] Real["+inode.getRealPath()+"]");
            } else if(item instanceof Directory) {
                Directory d = (Directory)item;
                StringBuilder sb = new StringBuilder();
                sb.append("Removing Directory: ").append(d.getVFSPath()).append("\n Real Path[")
                        .append(d.getRealPath()).append("]\n");
                d.getChildren().forEach(ti ->{
                    Inode inode = (Inode)ti;
                    sb.append("Removing File: ").append(inode.getFileNameType())
                            .append("\n Paths: VFS[").append(inode.getVFSPath()).append("] Real[")
                            .append(inode.getRealPath()).append("]\n");
                });
                display.accept(sb.toString());
                d.removeMe();
            }
        });
        cm.getItems().addAll(add,delete);
        cell.setContextMenu(cm);
        */
        return cell;
    }

}
