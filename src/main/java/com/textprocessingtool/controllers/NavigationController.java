package com.textprocessingtool.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.textprocessingtool.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class NavigationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox content;

    @FXML
    private Label route_dataManipulation;

    @FXML
    private Label route_textProcessing;

    @FXML
    void navDataManipulation(MouseEvent event) {
        loadPage("data_manipulation.fxml");
    }

    @FXML
    void navTextProcessing(MouseEvent event) {
        loadPage("text_processing.fxml");
    }

    @FXML
    void initialize() {
        

    }


    public void loadPage(String pageName) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(pageName));
            Parent page = loader.load();
            content.getChildren().clear();
            content.getChildren().add(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
