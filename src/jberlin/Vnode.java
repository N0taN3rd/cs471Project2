package jberlin;

import javafx.scene.control.TreeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Vnode extends TreeItem<String> {
    private String driveName;
    public Vnode(String driveName, Directory... directories){
        super("Drive: "+driveName);
        this.getChildren().addAll(directories);
    }

    public List<Directory> getDirectories(){
        List<Directory> kiddies = new ArrayList<>();
        for(TreeItem<String>  t : this.getChildren()){
            if(t instanceof Directory){
                System.out.println("getDirs t is Directorys");
                kiddies.add(((Directory)t).cloneMe());
            }

        }
        return kiddies;
    }



}
