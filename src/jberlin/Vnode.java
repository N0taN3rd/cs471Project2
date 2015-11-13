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
        this.driveName = driveName;
    }

    public List<Directory> getDirectories(){
        List<Directory> kiddies = new ArrayList<>();
        this.getChildren().stream().filter(t -> t instanceof Directory).forEach(t -> {
            System.out.println("getDirs t is Directorys");
            kiddies.add(((Directory) t).clone());
        });
        return kiddies;
    }

    public String getDriveName(){
        System.out.println("In getDriveName "+this.driveName);
        return this.driveName;
    }
}
