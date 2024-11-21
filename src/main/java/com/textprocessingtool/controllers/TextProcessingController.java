package com.textprocessingtool.controllers;

import com.textprocessingtool.textutils.MatcherUtil;
import com.textprocessingtool.utils.NotificationToast;
import com.textprocessingtool.utils.ValidationResult;
import com.textprocessingtool.utils.Validator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class TextProcessingController {

    private NotificationToast notificationToast = new NotificationToast();

    @FXML
    private Label error_query;

    @FXML
    private Label error_regex;

    @FXML
    private Label error_text;

    @FXML
    private Button match;

    @FXML
    private TextField query;

    @FXML
    private TextField regex;

    @FXML
    private Button replace;

    @FXML
    private Button search;

    @FXML
    private TextArea text;

    @FXML
    void match(MouseEvent event) {
        ValidationResult regexVal = Validator.validate(regex.getText(),"not_null", "regex");
        ValidationResult textVal = Validator.validate(text.getText(), "not_null");

        if(!regexVal.isSuccess() || !textVal.isSuccess()) {
            error_regex.setText(regexVal.getMessage());
            error_text.setText(textVal.getMessage());
        }
        else {
            boolean success = MatcherUtil.match(regex.getText(), text.getText());
            if(success) {
                notificationToast.showNotification(AlertType.CONFIRMATION, "Match Found", "There is a match for the word '" + text.getText() + "'");
            }
            else {
                notificationToast.showNotification(AlertType.CONFIRMATION, "No Match Found", "There is no match for the word '" + text.getText() + "'");
            }
        }
    }

    @FXML
    void replace(MouseEvent event) {

    }

    @FXML
    void search(MouseEvent event) {

    }

}
