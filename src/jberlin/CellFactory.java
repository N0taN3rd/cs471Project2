package jberlin;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.util.StringConverter;

import java.util.function.Consumer;

/**
 * Created by john on 11/11/15.
 */
public class CellFactory {

    public static TreeCell<String> makeCell(final Consumer<String> display){
        TextFieldTreeCell<String> cell  =  new MTreeCell(display);
        cell.setEditable(false);
        return cell;
    }

}
