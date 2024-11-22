package com.textprocessingtool.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.textprocessingtool.models.DataCollection;

import javafx.fxml.FXML;

public class ViewCollectionController {

    private DataCollection collection;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }

    public void setData(DataCollection item){
        this.collection = item;
        System.out.println(collection.getFeatures());
    }

}
