package jberlin;

import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;


import java.util.function.Consumer;

/**
 * Created by jberlin on 11/12/2015.
 */
public class MTreeCell extends TextFieldTreeCell<String> {
    private NewFileControler nfc;
    public MTreeCell(Consumer<String> display){
        super();

        ContextMenu cm = new ContextMenu();
        nfc = new NewFileControler();
        cm.showingProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem<String> item = getTreeItem();
            if(!(item instanceof Directory || item instanceof Inode)) {
                cm.hide();
            } else if(item instanceof Inode){
                cm.getItems().forEach(menuItem -> {
                    if(menuItem.getText().equals("Add"))
                        menuItem.setVisible(false);
                });
            }
        });
        MenuItem add = new MenuItem("Add");
        add.setOnAction(action -> {
            TreeItem<String> item = getTreeItem();
            if(item instanceof Directory){
                nfc.openStage();
                if(nfc.isGoodInfo()){
                    String[] info = nfc.getInfo();
                    Directory d = (Directory) item;
                    Inode file = new Inode(info[0],info[1],info[2],d.getPath());
                    d.getChildren().add(file.clone());
                    d.getMyParent().getChildren().add(file);
                }
            }
        });
        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction(action -> {
            TreeItem<String> item = getTreeItem();
            if(item instanceof Inode) {
                Inode inode = (Inode)item;
                inode.removeMe();
                display.accept("Removing File: "+inode.getFileNameType()+"\nPaths: VFS["+inode.getVFSPath()
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
        MenuItem viewData = new MenuItem("View Data");
        viewData.setOnAction(action->{
            //TODO Get viewing working
            TreeItem<String> item = getTreeItem();
            if(item instanceof Inode) {
                Inode inode = (Inode)item;
                display.accept(inode.getFileNameType()+": "+inode.getData());
            } else if(item instanceof Directory) {
                Directory d = (Directory)item;
                StringBuilder sb = new StringBuilder();
                sb.append(d.getPath().getVFSPath()).append("/\n");
                d.getChildren().forEach(ti -> {
                    Inode inode = (Inode)ti;
                    sb.append("\t").append(inode.getFileNameType())
                            .append(": ")
                            .append(inode.getData())
                            .append("\n");
                });
                display.accept(sb.toString());
            }
        });
        cm.getItems().addAll(add,delete,viewData);
        setContextMenu(cm);
    }

}
