package sample.view.FDAlert;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.view.FDDatePicker;

import java.util.Date;

public class FIOOrBirthDateFDAlert extends FDAlert {
    private final TextField lastNameField = new TextField();
    private final TextField firstNameField = new TextField();
    private final TextField middleNameField = new TextField();
    final private FDDatePicker datePicker = new FDDatePicker();

    public FIOOrBirthDateFDAlert(String nameOfAction) {
        super(nameOfAction + " игрока по ФИО или дате рождения");
        gridPane.addRow(0, new Label("Фамилия:   "), lastNameField);
        gridPane.addRow(1, new Label("Имя"), firstNameField);
        gridPane.addRow(2, new Label("Отчество:"), middleNameField);
        gridPane.addRow(3, new Label("Дата рождения:     "), datePicker);
    }

    public String getFirstNameValue() {
        return firstNameField.getText();
    }

    public String getMiddleNameValue() {
        return middleNameField.getText();
    }

    public String getLastNameValue() {
        return lastNameField.getText();
    }

    public Date getBirthDateValue() {
        return datePicker.getBirthDateValue();
    }
}
