module nandes.workshop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens nandes.workshop to javafx.fxml;
    exports nandes.workshop;
    exports nandes.workshop.controller;
    opens nandes.workshop.controller to javafx.fxml;
}