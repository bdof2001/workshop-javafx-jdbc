module nandes.workshop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens nandes.workshop to javafx.fxml;
    exports nandes.workshop;

    exports nandes.workshop.controller;
    opens nandes.workshop.controller to javafx.fxml;

    opens nandes.workshop.model.services to javafx.base;
    exports nandes.workshop.model.services to javafx.base;

    opens nandes.workshop.model.entities to javafx.base;
    exports nandes.workshop.model.entities to javafx.base;
}