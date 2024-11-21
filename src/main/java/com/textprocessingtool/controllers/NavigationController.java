package com.textprocessingtool.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.textprocessingtool.App;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private VBox route_textProcessing;

    @FXML
    void navTextProcessing(MouseEvent event) {
        loadPage("text_processing.fxml");
    }

    @FXML
    void initialize() {
        assert content != null : "fx:id=\"content\" was not injected: check your FXML file 'layout.fxml'.";
        assert route_textProcessing != null : "fx:id=\"route_textProcessing\" was not injected: check your FXML file 'layout.fxml'.";

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
