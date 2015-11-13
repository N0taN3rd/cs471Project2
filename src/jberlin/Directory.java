package jberlin;

import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Directory extends TreeItem<String> implements Cloneable {
    private String dName;
    private Directory parent;
    private Path path;
    public Directory(String dName,String drive, Inode... children) {
        super("Vnode: "+dName);
        this.dName = dName;
        this.getChildren().addAll(children);
        this.path  = new Path(drive,dName);
    }

    public Directory(Directory d){
        super("Directory: "+d.dName);
        List<Inode> kiddies = new ArrayList<>();
        this.dName = d.dName;
        d.getChildren().forEach(ti ->
            kiddies.add(((Inode) ti).clone())
        );
        this.parent = d;
        this.getChildren().addAll(kiddies);

        this.expandedProperty().addListener((bp,wasExpanded,isExpanded) ->{
            if(isExpanded) {
                this.expandParent();
            }
            if(!isExpanded)
                this.unExpandParent();
        });
        this.path = d.path;
    }

    public Path getPath(){
        return path;
    }

    public Directory getMyParent(){
        return this.parent;
    }

    public void expandParent(){
        if(this.parent != null){
            parent.expandParent();
        } else {
            this.getParent().setExpanded(true);
            this.setExpanded(true);
        }

    }
    public String getRealPath(){
        return path.getRealPath();
    }

    public String getVFSPath(){
        return path.getVFSPath();
    }

    @Override
    public Directory clone(){
        return new Directory(this);
    }

    public void unExpandParent(){
        if (this.parent != null){
            this.parent.setExpanded(false);
        } else {
            this.getParent().setExpanded(true);
        }
    }

    public void removeMe(){
        if(this.parent != null){
            this.parent.removeMe();
        }
        this.getParent().getChildren().remove(this);
    }



}
