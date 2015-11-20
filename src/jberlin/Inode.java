package jberlin;

import javafx.scene.control.TreeItem;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Inode extends TreeItem<String> implements Cloneable {
    private String fileName;
    private String ext;
    private String data;
    private Path path;
    private Inode parent;

    public Inode(String fileName, String ext, String data,Path path) {
        super("Inode: "+fileName+"."+ext);
        this.fileName = fileName;
        this.ext = ext;
        this.data = data;
        this.getChildren().addAll(new TreeItem<>("File Name: "+fileName),new TreeItem<>("File type: "+ext),
                new TreeItem<>("Data: "+data));
        this.path = path;
    }

    public Inode(Inode inode) {
        super(inode.fileName+"."+inode.ext);
        this.fileName = inode.fileName;
        this.ext = inode.ext;
        this.data = inode.data;
        this.parent = inode;
        /*
        this.getChildren().addAll( new TreeItem<>("File Name: "+inode.fileName),new TreeItem<>("File type: "+inode.ext),
                new TreeItem<>("Data: "+inode.data));
                */
        this.expandedProperty().addListener((bp,wasExpanded,isExpanded) ->{
            if(isExpanded)
                this.expandParent();
            if(!isExpanded)
                this.unExpandParent();
        });
        this.path = inode.path;
    }


    @Override
    public Inode clone(){
        return new Inode(this);
    }

    public void removeMe(){
        if(this.parent != null){
            this.parent.removeMe();
        }
        this.getParent().getChildren().remove(this);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Inode getMyParent() {
        return parent;
    }

    public void setParent(Inode parent) {
        this.parent = parent;
    }

    public String getFileNameType(){
        return fileName+"."+ext;
    }

    public String getRealPath(){
        return path.getRealPath()+"/"+fileName+"."+ext;
    }

    public String getVFSPath(){
        return path.getVFSPath()+"/"+fileName+"."+ext;
    }

    public void expandParent(){
        if(this.parent != null){
            parent.expandParent();
        } else {
            this.setExpanded(true);
        }
    }

    public void unExpandParent(){
        if (this.parent != null){
            this.parent.unExpandParent();
        } else {
            this.setExpanded(false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inode inode = (Inode) o;

        if (fileName != null ? !fileName.equals(inode.fileName) : inode.fileName != null) return false;
        if (ext != null ? !ext.equals(inode.ext) : inode.ext != null) return false;
        if (data != null ? !data.equals(inode.data) : inode.data != null) return false;
        return !(parent != null ? !parent.equals(inode.parent) : inode.parent != null);

    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
