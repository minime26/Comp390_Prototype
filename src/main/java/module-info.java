module com.example.fitness_app_demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;

    opens com.example.fitness_app_demo1 to javafx.fxml;
    exports com.example.fitness_app_demo1;
}