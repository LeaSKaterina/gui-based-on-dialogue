package sample.view.FDAlert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ChangePaginationFDAlert extends FDAlert{
    TextField textField = new TextField();

    public ChangePaginationFDAlert(){
        super("Изменение вида таблицы");
        VBox vBox = new VBox(new Label("Введите количество игроков для одной страницы:"), textField);
        setContentOfDialogPane(vBox);
    }

    public int getInt(){
        return Integer.parseInt(textField.getText());
    }
}
