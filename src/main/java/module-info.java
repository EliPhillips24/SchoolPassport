module com.example.schoolpassport {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.schoolpassport to javafx.fxml;
    exports com.example.schoolpassport;
}