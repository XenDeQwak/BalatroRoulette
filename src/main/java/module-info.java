module com.balatro.randomizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.balatro.randomizer to javafx.fxml;
    exports com.balatro.randomizer;
}
