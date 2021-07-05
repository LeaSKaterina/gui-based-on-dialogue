package sample.view.FDAlert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TeamNameOrHomeTownFDAlert extends FDAlert {
    final private TextField teamNameField = new TextField();
    final private TextField homeTownField = new TextField();

    public TeamNameOrHomeTownFDAlert(String nameOfAction) {
        super(nameOfAction + " игрока по названию команды или домашнему городу");

        gridPane.addRow(0, new Label("Название команды:   "), teamNameField);
        gridPane.addRow(1, new Label("Домашний город:     "), homeTownField);
    }
    public String getTeamNameValue(){
        return teamNameField.getText();
    }
    public String getHomeTownValue(){
        return homeTownField.getText();
    }
}
