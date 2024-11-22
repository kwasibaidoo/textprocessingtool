module com.textprocessingtool {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.textprocessingtool to javafx.fxml;
    opens com.textprocessingtool.controllers to javafx.fxml;
    opens com.textprocessingtool.models to javafx.base;
    exports com.textprocessingtool;
    exports com.textprocessingtool.controllers;
    exports com.textprocessingtool.models;
}
