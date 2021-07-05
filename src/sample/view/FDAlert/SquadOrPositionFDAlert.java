package sample.view.FDAlert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.model.SquadEnum;
import sample.view.SquadInputBox;

public class SquadOrPositionFDAlert extends FDAlert{
    final private SquadInputBox squadInputBox = new SquadInputBox();
    final private TextField positionField = new TextField();

    public SquadOrPositionFDAlert(String nameOfAction){
        super(nameOfAction + " игрока по составу или позиции");
        gridPane.addRow(0, new Label("Состав:    "), squadInputBox);
        gridPane.addRow(1, new Label("Позиция:     "), positionField);
    }

    public SquadEnum getSquadValue(){
        return SquadEnum.initSquad(squadInputBox.toString());
    }
    public String getPositionValue(){
        return positionField.getText();
    }
}
