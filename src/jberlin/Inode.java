package jberlin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jberlin on 11/8/2015.
 */
public class Inode {
    private StringProperty fileName;
    private StringProperty ext;
    private StringProperty data;
    public StringProperty file;
    private Directory parent;

    public Inode(StringProperty fileName, StringProperty ext, StringProperty data, Directory parent) {
        this.fileName = fileName;
        this.ext = ext;
        this.data = data;
        this.file = new SimpleStringProperty(fileName.get()+"."+ext.get());
        this.parent = parent;
    }

    public Inode(String fileName, String ext, String data, Directory parent) {
        this.fileName = new SimpleStringProperty(fileName);
        this.ext = new SimpleStringProperty(ext);
        this.data = new SimpleStringProperty(data);
        this.file = new SimpleStringProperty(fileName+"."+ext);
        this.parent = parent;
    }

    public String getFileName() {
        return fileName.get();
    }

    public StringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public String getExt() {
        return ext.get();
    }

    public StringProperty extProperty() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext.set(ext);
    }

    public String getData() {
        return data.get();
    }

    public StringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public String getFile() {
        return file.get();
    }

    public StringProperty fileProperty() {
        return file;
    }

    public void setFile(String file) {
        this.file.set(file);
    }

    @Override
    public String toString() {
        return "Inode{" +
                "file=" + file +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inode)) return false;

        Inode inode = (Inode) o;

        if (fileName != null ? !fileName.equals(inode.fileName) : inode.fileName != null) return false;
        if (ext != null ? !ext.equals(inode.ext) : inode.ext != null) return false;
        if (data != null ? !data.equals(inode.data) : inode.data != null) return false;
        return !(file != null ? !file.equals(inode.file) : inode.file != null);

    }

    @Override
    public int hashCode() {
        int result = fileName != null ? fileName.hashCode() : 0;
        result = 31 * result + (ext != null ? ext.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (file != null ? file.hashCode() : 0);
        return result;
    }

}
