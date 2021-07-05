package sample.view.FDAlert;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;

public class FDAlert extends Alert {
    protected GridPane gridPane = new GridPane();

    public FDAlert(String title) {
        super(Alert.AlertType.NONE);
        setTitle(title);
        getButtonTypes().add(new ButtonType("OK"));
        getDialogPane().setContent(gridPane);
    }

    public FDAlert(String title, Node content){
        super(Alert.AlertType.NONE);
        setTitle(title);
        getButtonTypes().add(new ButtonType("OK"));
        getDialogPane().setContent(content);
    }

    public void setContentOfDialogPane(Node var1){
        getDialogPane().setContent(var1);
    }
}
