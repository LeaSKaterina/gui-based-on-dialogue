package sample.view.FDAlert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;
import sample.model.SquadEnum;
import sample.view.FDDatePicker;
import sample.view.SquadInputBox;

import java.util.Date;

public class AddFDAlert extends FDAlert {
    private final TextField lastNameField = new TextField();
    private final TextField firstNameField = new TextField();
    private final TextField middleNameField = new TextField();
    private final FDDatePicker datePicker = new FDDatePicker();
    private final TextField teamNameField = new TextField();
    private final TextField homeTownField = new TextField();
    private final SquadInputBox squadInputBox = new SquadInputBox();
    private final TextField positionField = new TextField();

    public AddFDAlert(){
        super("Добавление игрока");

        gridPane.addRow(0, new Label("Фамилия:   "), lastNameField);
        gridPane.addRow(1, new Label("Имя"), firstNameField);
        gridPane.addRow(2, new Label("Отчество:"), middleNameField);
        gridPane.addRow(3, new Label("Дата рождения:     "), datePicker);
        gridPane.addRow(4, new Label("Название команды:    "), teamNameField);
        gridPane.addRow(5, new Label("Домашний город:     "), homeTownField);
        gridPane.addRow(6, new Label("Состав:    "), squadInputBox);
        gridPane.addRow(7, new Label("Позиция:     "), positionField);

    }

    public String getFirstName() {
        if (firstNameField.getText().isEmpty()) return "не указано";
        return firstNameField.getText();
    }

    public String getLastName() {
        if (lastNameField.getText().isEmpty()) return "не указано";
        return lastNameField.getText();
    }

    public String getMiddleName() {
        if (middleNameField.getText().isEmpty()) return "не указано";
        return middleNameField.getText();
    }

    public Date getBirthDateValue(){
        return datePicker.getBirthDateValue();
    }

    public String getTeamNameValue(){
        if (teamNameField.getText().isEmpty()) return "не указано";
        return teamNameField.getText();
    }
    public String getHomeTownValue(){
        if (homeTownField.getText().isEmpty()) return "не указано";
        return homeTownField.getText();
    }
    public SquadEnum getSquadValue(){
        return SquadEnum.initSquad(squadInputBox.toString());
    }
    public String getPositionValue(){
        if (positionField.getText().isEmpty()) return "не указано";
        return positionField.getText();
    }

}
