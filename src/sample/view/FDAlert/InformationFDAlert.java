package sample.view.FDAlert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InformationFDAlert extends FDAlert{
    public InformationFDAlert(int amount){
        super("Удаление игроков");
        String message;
        if (amount != 0){
            message = "Удалены игроки в количестве " + amount + ".";
        } else{
            message = "Игроков с данной информацией не найдено.";
        }
        gridPane.addRow(0, new Label(message));
        ((Button) getDialogPane().lookupButton(getButtonTypes().get(0))).setOnAction((ae) -> close());
    }
}
