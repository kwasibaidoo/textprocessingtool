package com.textprocessingtool.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.textprocessingtool.App;
import com.textprocessingtool.models.DataCollection;
import com.textprocessingtool.utils.ValidationResult;
import com.textprocessingtool.utils.Validator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DataManipulationController {

    private Scene scene;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<DataCollection> collections_table;

    @FXML
    private TableColumn<DataCollection, String> column_name;

    @FXML
    private Label error_name;

    @FXML
    private Label error_features;

    @FXML
    private TextField name;

    @FXML
    private TextField features;

    private ObservableList<DataCollection> table_content = FXCollections.observableArrayList();

    @FXML
    void delete_collection(MouseEvent event) {
        DataCollection selected = collections_table.getSelectionModel().getSelectedItem();
        table_content.remove(selected);
    }

    @FXML
    void submit(MouseEvent event) {
        ValidationResult nameVal = Validator.validate(name.getText(), "not_null");
        if(!nameVal.isSuccess()) {
            error_name.setText(nameVal.getMessage());
        }
        else{
            error_name.setText("");
            String[] featuresList = features.getText().split(",");
            ArrayList<String> arrList = new ArrayList<>();
            for (String string : featuresList) {
                arrList.add(string);
            }
            DataCollection dataCollection = new DataCollection(name.getText(),arrList);
            collections_table.getItems().add(dataCollection);
        }
    }

    @FXML
    void update_collection(MouseEvent event) {

    }

    @FXML
    void view_collection(MouseEvent event) {
        // open a new window
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("view_collection.fxml"));
        
        try {
            scene = new Scene(fxmlLoader.load());
            ViewCollectionController viewCollectionController = fxmlLoader.getController();
            DataCollection selectedCollection = collections_table.getSelectionModel().getSelectedItem();
            viewCollectionController.setData(selectedCollection);
            // viewCollectionController
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("View Collection");
        stage.showAndWait();
    }

    @FXML
    void initialize() {
        column_name.setCellValueFactory(new PropertyValueFactory<DataCollection, String>("name"));
        collections_table.setItems(table_content);
    }

}
