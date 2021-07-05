package sample.view.FDAlert.FindFDAlert;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.controller.Controller;
import sample.model.PlayerModel;
import sample.view.FDAlert.SquadOrPositionFDAlert;
import sample.view.PaginatedTable;

public class FindSquadOrPositionFDAlert extends SquadOrPositionFDAlert {

    private final PaginatedTable table = new PaginatedTable(new Controller());
    private final Button findButton = new Button("Найти");

    public FindSquadOrPositionFDAlert() {
        super("Нахождение игрока");
        gridPane.add(findButton, 0, 2);
        gridPane.addRow(3, new Label("Найдены следующие игроки: "));
        gridPane.add(table, 0, 4, 2, 1);
    }

    public void showTheTable(ObservableList<PlayerModel> list) {
        table.getTableController().updateModelList(list);
        table.getTableController().update();
    }

    public void setOnActionFindButton(EventHandler<ActionEvent> var1) {
        findButton.setOnAction(var1);
    }
}
