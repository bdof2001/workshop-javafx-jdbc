package nandes.workshop.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import nandes.workshop.Main;
import nandes.workshop.model.services.DepartmentService;
import nandes.workshop.model.services.SellerService;
import nandes.workshop.util.Alerts;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class MainViewController implements Initializable {

    @FXML
    private MenuItem menuItemSeller;

    @FXML
    private MenuItem menuItemDepartment;

    @FXML
    private MenuItem menuItemAbout;

    @FXML
    public void onMenuItemSellerAction() {
        loadView("/nandes/workshop/gui/SellerList.fxml", (SellerListController controller) -> {
            controller.setSellerService(new SellerService());
            controller.updateTableView();
        });
    }

    @FXML
    public void onMenuItemDepartmentAction() {
        loadView("/nandes/workshop/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
            controller.setDepartmentService(new DepartmentService());
            controller.updateTableView();
        });
    }


    @FXML
    public void onMenuItemAboutAction() {
        loadView("/nandes/workshop/gui/About.fxml", x -> {
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
            VBox newVBox = loader.load();

            Scene mainScene = Main.getMainScene();
            VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

            Node mainMenu = mainVBox.getChildren().getFirst();
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

            T controller = loader.getController();
            initializingAction.accept(controller);

        } catch (IOException e) {
            Alerts.showAlert("IOException", "Error loading view", e.getMessage(), Alert.AlertType.ERROR);
        }
    }
}
