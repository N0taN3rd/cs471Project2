package jberlin;


import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Directory extends TreeItem<String> {
    private String dName;
    private Directory parent;
    public Directory(String dName, Inode... children) {
        super("Directory: "+dName);
        this.dName = dName;
        this.getChildren().addAll(children);
    }

    public Directory(Directory d){
        super("Directory: "+d.dName);
        List<Inode> chiddies = new ArrayList<>();
        this.dName = d.dName;
        for(TreeItem<String> ti : this.getChildren()){
            if(ti instanceof Inode){
                chiddies.add(((Inode)ti).getMyClone());
            }
        }
        this.getChildren().addAll(chiddies);
    }


    public Directory cloneMe(){
        return new Directory(this);
    }




}
