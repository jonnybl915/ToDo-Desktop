package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField text;
    @FXML                                //this is initializing the fields for us
    ListView list;

    ObservableList<ToDoItem> items = FXCollections.observableArrayList();

    public void onAdd(){
        ToDoItem item = new ToDoItem(text.getText(), false);
        items.add(item);
        text.clear();
    }
    public void onRemove(){
        SelectionModel model = list.getSelectionModel();
        ToDoItem item = (ToDoItem) model.getSelectedItem();
        items.remove(item);

    }
    public void onToggle(){
        SelectionModel model = list.getSelectionModel();
        ToDoItem item = (ToDoItem) model.getSelectedItem();
        if (item ==null) {
            item.isDone = !item.isDone;
            list.refresh();
        }

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(items);
    }
}
