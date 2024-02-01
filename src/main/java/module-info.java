module com.example.securin2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.securin2 to javafx.fxml;
    exports com.example.securin2;
}