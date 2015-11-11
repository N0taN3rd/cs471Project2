package jberlin;

import javafx.scene.control.TreeItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Directory extends TreeItem<String> {
    private String dName;
    private Directory parent;
    public Directory(String dName, Inode... children) {
        super("Vnode: "+dName);
        this.dName = dName;
        this.getChildren().addAll(children);
    }

    public Directory(Directory d){
        super("Directory: "+d.dName);
        List<Inode> chiddies = new ArrayList<>();
        this.dName = d.dName;
        for(TreeItem<String> ti : d.getChildren()){
            if(ti instanceof Inode){
                System.out.println("Directory d constructor ti is instance of Inode");
                chiddies.add(((Inode)ti).getMyClone());
            }
        }
        this.parent = d;
        this.getChildren().addAll(chiddies);

        this.expandedProperty().addListener((bp,wasExpanded,isExpanded) ->{
            System.out.println(this.dName+" wasExpanded="+wasExpanded+" isExpanded="+isExpanded);
            if(isExpanded)
                this.expandParent();
            if(!isExpanded)
                this.unExpandParent();
        });
    }

    public void expandParent(){
        if(this.parent != null){
            parent.expandParent();
            System.out.println("Directory Parent not null and parent is set to expanded");
        } else {
            this.getParent().setExpanded(true);
            this.setExpanded(true);
        }

    }


    public Directory cloneMe(){
        return new Directory(this);
    }

    public void unExpandParent(){
        if (this.parent != null){
            System.out.println("Directory Parent not null and parent is set not expanded");
            this.parent.setExpanded(false);
        } else {
            this.getParent().setExpanded(true);
        }
    }

    public void removeMe(){
        if(this.parent != null){
            System.out.println("Remove me Directory parent is not null");
            this.parent.removeMe();
        }
        System.out.println("Remove me Directory");
        this.getParent().getChildren().remove(this);
    }



}
