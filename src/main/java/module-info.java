module com.textprocessingtool {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;

    opens com.textprocessingtool to javafx.fxml;
    opens com.textprocessingtool.controllers to javafx.fxml;
    exports com.textprocessingtool;
    exports com.textprocessingtool.controllers;
}
