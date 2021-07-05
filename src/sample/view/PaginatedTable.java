package sample.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.controller.Controller;
import sample.controller.PaginatedTableController;

public class PaginatedTable extends VBox {

    final private PaginatedTableController tableController;
    final private TableOfPlayers table = new TableOfPlayers();


    public PaginatedTable(Controller controller) {
        this.tableController = controller.getTableController();
        TableLabelSet labelSet = new TableLabelSet();
        this.tableController.init(controller.getModel(), table, labelSet);

        Button firstPage = new Button("1");
        Button lastPage = new Button("...");
        Button nextPage = new Button(">>");
        Button previousPage = new Button("<<");
        Button changePagination = new Button("Изменить количество записей на странице");

        getChildren().addAll(
                new HBox(firstPage, lastPage, previousPage, nextPage, changePagination),
                labelSet, table);

        setSpacing(5);

        firstPage.setOnAction(ae -> tableController.toTheFirstPage());
        lastPage.setOnAction(ae -> tableController.toTheLastPage());
        nextPage.setOnAction(ae -> tableController.toTheNextPage());
        previousPage.setOnAction(ae -> tableController.toThePreviousPage());

        changePagination.setOnAction(ae -> tableController.changePagination());
    }

    public TableOfPlayers getTableOfPlayers(){
        return table;
    }

    public PaginatedTableController getTableController(){
        return tableController;
    }

}
