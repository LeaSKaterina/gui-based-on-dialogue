package sample.view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TableLabelSet extends VBox {

    final private Label numberOfPagesLbl = new Label("Всего страниц: ");
    final private Label currentPageLbl = new Label("Текущая страница: ");
    final private Label numberOfPlayersOnPageLbl = new Label("Количество записей на странице: ");

    TableLabelSet(){
        getChildren().add(new HBox(numberOfPagesLbl, new Label(" | "), currentPageLbl, new Label(" | "), numberOfPlayersOnPageLbl));
    }

    public void update(int numberOfPages, int currentPageNumber, int numberOfPlayersOnPage) {
        numberOfPagesLbl.setText("Всего страниц: " + numberOfPages);
        currentPageLbl.setText("Текущая страница: " + (currentPageNumber+1));
        numberOfPlayersOnPageLbl.setText("Количество записей на странице: " + numberOfPlayersOnPage);
    }

}
