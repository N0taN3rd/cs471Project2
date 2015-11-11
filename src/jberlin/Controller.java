package jberlin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TreeView<String> fsA;
    @FXML private TreeView<String> fsB;
    @FXML private TreeView<String> fsC;
    @FXML private TreeView<String> vsf;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Vnode a = new Vnode("A",
                new Directory("tests",
                        new Inode("Test1","txt","this is test 1"),
                        new Inode("Test2","txt","this is test 2"),
                        new Inode("Test3","txt","this is test 3")),
                new Directory("inputs",
                        new Inode("Input","dat","does this work"),
                        new Inode("Input2","dat","I really hope it does"),
                        new Inode("Input3","dat","if it doe not fuck")),
                new Directory("myGf",
                        new Inode("Caroly","gf","man she is nice"),
                        new Inode("What I like about her","likes","she is nice and beautiful"),
                        new Inode("Carolyn2","gf","will she attend my graduation?")));

        Vnode b = new Vnode("B",
                new Directory("tests",
                        new Inode("Test1","txt","this is test 1"),
                        new Inode("Test2","txt","this is test 2"),
                        new Inode("Test3","txt","this is test 3")),
                new Directory("inputs",
                        new Inode("Input","dat","does this work"),
                        new Inode("Input2","dat","I really hope it does"),
                        new Inode("Input3","dat","if it doe not fuck")),
                new Directory("myGf",
                        new Inode("Caroly","gf","man she is nice"),
                        new Inode("What I like about her","likes","she is nice and beautiful"),
                        new Inode("Carolyn2","gf","will she attend my graduation?")));

        Vnode c = new Vnode("C",
                new Directory("tests",
                        new Inode("Test1","txt","this is test 1"),
                        new Inode("Test2","txt","this is test 2"),
                        new Inode("Test3","txt","this is test 3")),
                new Directory("inputs",
                        new Inode("Input","dat","does this work"),
                        new Inode("Input2","dat","I really hope it does"),
                        new Inode("Input3","dat","if it doe not fuck")),
                new Directory("myGf",
                        new Inode("Caroly","gf","man she is nice"),
                        new Inode("What I like about her","likes","she is nice and beautiful"),
                        new Inode("Carolyn2","gf","will she attend my graduation?")));

        fsA.setCellFactory(factory -> CellFactory.makeCell());
        fsA.setRoot(a);

        fsB.setCellFactory(factory -> CellFactory.makeCell());
        fsB.setRoot(b);

        fsC.setCellFactory(factory -> CellFactory.makeCell());
        fsC.setRoot(c);

        vsf.setCellFactory(factory->CellFactory.makeCell());
        VSF root = new VSF("VSF",a,b,c);
        vsf.setRoot(root);



    }
}

/*

        fsA.setContextMenu(cm);

          private EventHandler<ActionEvent> add = event -> {
        TreeItem<String> titem =  fsA.getSelectionModel().getSelectedItem();
        if(titem instanceof Inode) {
            System.out.println("Its an Inode");
        } else if(titem instanceof Vnode) {
            System.out.println("Its a Vnode");
        } else if(titem instanceof Directory) {
            System.out.println("Its a directory");
        } else {
            System.out.println("Its something else");
        }
    };

    private EventHandler<ActionEvent> delete = event -> {
        TreeItem<String> titem =  fsA.getSelectionModel().getSelectedItem();
        if(titem instanceof Inode) {
            System.out.println("Its an Inode");
            titem.getParent().getChildren().remove(titem);
        } else if(titem instanceof Vnode) {
            System.out.println("Its a Vnode");
        } else if(titem instanceof Directory) {
            System.out.println("Its a directory");
            titem.getParent().getChildren().remove(titem);
        } else {
            System.out.println("Its something else");
        }
    };
 */
