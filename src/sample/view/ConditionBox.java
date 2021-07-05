package sample.view;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ConditionBox extends VBox {
    final private RadioButton FIOOrBirthDateBtn = new RadioButton(" ФИО и дате рождения");
    final private RadioButton teamNameOrHomeTownBtn = new RadioButton(" названию команды или родному городу");
    final private RadioButton squadOrPositionBtn = new RadioButton(" составу или позиции");

    public ConditionBox(String name) {
        ToggleGroup group = new ToggleGroup();
        group.getToggles().addAll(FIOOrBirthDateBtn, teamNameOrHomeTownBtn, squadOrPositionBtn);
        getChildren().addAll(new Label(name + " по: "), FIOOrBirthDateBtn, teamNameOrHomeTownBtn, squadOrPositionBtn);
    }

    public RadioButton getFIOOrBirthDateBtn() {
        return FIOOrBirthDateBtn;
    }

    public RadioButton getTeamNameOrHomeTownBtn() {
        return teamNameOrHomeTownBtn;
    }

    public RadioButton getSquadOrPositionBtn() {
        return squadOrPositionBtn;
    }
}


