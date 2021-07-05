package sample.view;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.controller.Controller;

public class View extends VBox {
    private static Controller controller = new Controller();

    public View(Stage primaryStage) {
        FDMenuBar menuBar = new FDMenuBar();
        FDToolbox toolbox = new FDToolbox();
        PaginatedTable table = new PaginatedTable(controller);
        getChildren().addAll(menuBar, toolbox, table);

        menuBar.getMenus().get(1).getItems().get(0).setOnAction((ae) -> controller.addPlayer());
        ((Button) toolbox.getChildren().get(0)).setOnAction((ae) -> controller.addPlayer());

        menuBar.getMenus().get(1).getItems().get(2).setOnAction((ae) -> controller.deletePlayer());
        ((Button) toolbox.getChildren().get(1)).setOnAction((ae) ->  controller.deletePlayer());

        menuBar.getMenus().get(1).getItems().get(1).setOnAction((ae) -> controller.findPlayer());
        ((Button) toolbox.getChildren().get(2)).setOnAction((ae) ->  controller.findPlayer());

        menuBar.getMenus().get(0).getItems().get(0).setOnAction(ae -> controller.saveDoc(primaryStage));
        ((Button) toolbox.getChildren().get(4)).setOnAction((ae) ->  controller.saveDoc(primaryStage));

        menuBar.getMenus().get(0).getItems().get(1).setOnAction(ae -> controller.openDoc(primaryStage));
        ((Button) toolbox.getChildren().get(3)).setOnAction((ae) ->  controller.openDoc(primaryStage));

    }

    public static Controller getController() {
        return controller;
    }
}
