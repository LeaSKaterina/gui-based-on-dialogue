package sample.view;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

public class SquadInputBox extends HBox {
    final private RadioButton mainSquad = new RadioButton("основной");
    final private RadioButton reserveSquad = new RadioButton("запасной");
    final private ToggleGroup group = new ToggleGroup();

    public SquadInputBox() {
        group.getToggles().addAll(mainSquad, reserveSquad);
        getChildren().addAll(mainSquad, reserveSquad);
    }

    public String toString() {
        if (group.getSelectedToggle() != null) {
            if (mainSquad.isSelected()) {
                return "основной";
            } else {
                return "запасной";
            }
        }
        return "";
    }
}
