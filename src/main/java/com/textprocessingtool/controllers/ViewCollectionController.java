package com.textprocessingtool.controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.textprocessingtool.models.CollectionDAO;
import com.textprocessingtool.models.DataCollection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ViewCollectionController {

    private CollectionDAO dao = CollectionDAO.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<DataCollection> collections_table;

    @FXML
    private TableColumn<DataCollection, String> data;

    @FXML
    private Button delete;

    @FXML
    private TableColumn<DataCollection, Integer> id_column;

    @FXML
    private Button update;

    @FXML
    void delete(MouseEvent event) {
        DataCollection selectedItem = collections_table.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            // Remove the selected item
            collections_table.getItems().remove(selectedItem);
            dao.deleteById(selectedItem.getId());
        }
    }

    @FXML
    void update(MouseEvent event) {

    }

    ObservableList<DataCollection> dataCollectionList = FXCollections.observableArrayList();

    @FXML
    void initialize() {
        id_column.setCellValueFactory(new PropertyValueFactory<>("id"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));

        collections_table.setItems(dataCollectionList);

    }

    public void setDataCollection(List<DataCollection> all) {
        // ObservableList<DataCollection> dataCollectionList = FXCollections.observableArrayList(all);
        dataCollectionList.addAll(all);
        collections_table.setItems(dataCollectionList);
    }

}
