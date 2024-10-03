module com.example.ass_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ass_1 to javafx.fxml;
    exports com.example.ass_1;
}