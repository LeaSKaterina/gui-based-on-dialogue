package sample.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


//обработчики событий устанавливаются в конструкторе Controller
public class FDToolbox extends HBox {

    public FDToolbox() {
        getChildren().addAll(new AddButton(), new DeleteButton(), new FindButton(), new OpenButton(), new SaveButton());
        setBackground(new Background(new BackgroundFill(new Color(0.1, 0.1, 0.1, 0.2), new CornerRadii(0), new Insets(0))));
        setPadding(new Insets(3, 0, 5, 10));
    }

    private class AddButton extends Button {
        public AddButton() {
            super("+");
        }
    }

    private class DeleteButton extends Button {
        public DeleteButton() {
            super("-");
        }
    }

    private class FindButton extends Button {
        public FindButton() {
            super("F");
        }
    }

    private class OpenButton extends Button {
        public OpenButton() {
            super("O");
        }
    }

    private class SaveButton extends Button {
        public SaveButton() {
            super("S");
        }
    }
}
