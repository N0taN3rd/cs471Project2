package jberlin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class VFSController implements Initializable {
    @FXML private TreeView<String> fsA;
    @FXML private TreeView<String> fsB;
    @FXML private TreeView<String> fsC;
    @FXML private TreeView<String> vsf;
    @FXML private TextArea opDisplay;
    @FXML private TextArea outPut;
    private final Consumer<String> display = s -> outPut.appendText(s + "\n\n");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        outPut.setEditable(false);
        opDisplay.setEditable(false);
        String builder = "The tree with root node VSF \nis the tree you can perform operations on\n\n" +
                "The operations available \nto you are done through mouse interaction\n\n" +
                "Right click on the items \nto view the options\n\n";
        opDisplay.setText(builder);

        Path[] aPath = {new Path("A", "tests"), new Path("A", "inputs"), new Path("A", "myGF")};
        Path[] bPath = {new Path("A", "tests2"), new Path("A", "inputs2"), new Path("A", "myGF2")};
        Path[] cPath = {new Path("A", "tests3"), new Path("A", "inputs2"), new Path("A", "myGF3")};
        Vnode a = new Vnode("A",
                new Directory("tests", "A",
                        new Inode("Test1", "txt", "this is test 1", aPath[0]),
                        new Inode("Test2", "txt", "this is test 2", aPath[0]),
                        new Inode("Test3", "txt", "this is test 3", aPath[0])),
                new Directory("inputs", "A",
                        new Inode("Input", "dat", "does this work", bPath[1]),
                        new Inode("Input2", "dat", "I really hope it does", aPath[1]),
                        new Inode("Input3", "dat", "if it doe not fuck", aPath[1])),
                new Directory("myGf", "A",
                        new Inode("Caroly", "gf", "man she is nice", aPath[2]),
                        new Inode("What I like about her", "likes", "she is nice and beautiful", aPath[2]),
                        new Inode("Carolyn2", "gf", "will she attend my graduation?", aPath[2])));

        Vnode b = new Vnode("B",
                new Directory("tests2", "B",
                        new Inode("Test4", "txt", "this is test 1", bPath[0]),
                        new Inode("Test5", "txt", "this is test 2", bPath[0]),
                        new Inode("Test6", "txt", "this is test 3", bPath[0])),
                new Directory("inputs2", "B",
                        new Inode("Input4", "dat", "does this work", bPath[1]),
                        new Inode("Input5", "dat", "I really hope it does", bPath[1]),
                        new Inode("Input6", "dat", "if it doe not fuck", bPath[1])),
                new Directory("myGf2", "B",
                        new Inode("Caroly3", "gf", "her red hair is awesome", bPath[2]),
                        new Inode("What I like about her2", "likes", "kindest person on the planet", bPath[2]),
                        new Inode("Carolyn4", "gf", "surprises: picnic", bPath[2])));

        Vnode c = new Vnode("C",
                new Directory("tests3", "C",
                        new Inode("Test7", "txt", "this is test 1", cPath[0]),
                        new Inode("Test8", "txt", "this is test 2", cPath[0]),
                        new Inode("Test9", "txt", "this is test 3", cPath[0])),
                new Directory("inputs3", "C",
                        new Inode("Input7", "dat", "does this work", cPath[1]),
                        new Inode("Input8", "dat", "I really hope it does", cPath[1]),
                        new Inode("Input8", "dat", "if it doe not fuck", cPath[1])),
                new Directory("myGf3", "C",
                        new Inode("Caroly5", "gf", "really smart", cPath[2]),
                        new Inode("What I like about he3r", "likes", "really really smart", cPath[2]),
                        new Inode("Carolyn6", "gf", "her eyes are so beautiful", cPath[2])));

        fsA.setRoot(a);

        fsB.setRoot(b);

        fsC.setRoot(c);

        vsf.setCellFactory(factory -> CellFactory.makeCell(display));
        VSF root = new VSF(a, b, c);
        vsf.setRoot(root);

    }
}
