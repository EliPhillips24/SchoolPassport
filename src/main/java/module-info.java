module com.example.schoolpassport {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires webcam.capture;


    opens com.example.schoolpassport to javafx.fxml;
    exports com.example.schoolpassport;
}