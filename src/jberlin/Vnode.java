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
        this.getChildren().forEach(t ->
            kiddies.add(((Directory) t).clone())
        );
        return kiddies;
    }

    public String getDriveName(){
        return this.driveName;
    }
}
