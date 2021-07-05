package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import sample.model.Model;
import sample.model.PlayerModel;
import sample.view.FDAlert.ChangePaginationFDAlert;
import sample.view.TableLabelSet;
import sample.view.TableOfPlayers;

public class PaginatedTableController {
    private Model model;
    private TableOfPlayers table;
    private TableLabelSet labelSet;

    private int currentPageNumber = 0;
    private int numberOfPlayersOnPage = 5;

    public void init(Model model, TableOfPlayers table, TableLabelSet labelSet){
        this.model = model;
        this.table = table;
        this.labelSet = labelSet;
        this.labelSet.update(1,0,5);
    }

    public void updateModelList(ObservableList<PlayerModel> list){
        model.setListOfPlayers(list);
    }

    private void updateTable(){
        ObservableList<PlayerModel> bufferList = FXCollections.observableArrayList();
        for (int i = 0; i < numberOfPlayersOnPage; i++){
            int index = currentPageNumber*numberOfPlayersOnPage + i;
            if (index >= model.getListOfPlayers().size()) break;
            bufferList.add(model.getListOfPlayers().get(index));
        }
        table.setItems(bufferList);
    }

    public void update(){
        updateTable();
        labelSet.update(calculateNumberOfPages(), currentPageNumber, numberOfPlayersOnPage);
    }

    private int calculateNumberOfPages(){
        if (model.getListOfPlayers().size() == 0){
            return 1;
        }
        if (model.getListOfPlayers().size() % numberOfPlayersOnPage != 0) {
            return model.getListOfPlayers().size() / numberOfPlayersOnPage + 1;
        } else{
            return model.getListOfPlayers().size() / numberOfPlayersOnPage;
        }
    }

    public void toTheNextPage(){
        if (currentPageNumber < calculateNumberOfPages() - 1) {
            currentPageNumber++;
            update();
        }
    }

    public void toThePreviousPage(){
        if (currentPageNumber > 0) {
            currentPageNumber--;
            update();
        }
    }

    public void toTheFirstPage(){
        currentPageNumber = 0;
        update();
    }

    public void toTheLastPage(){
        currentPageNumber = calculateNumberOfPages()-1;
        update();
    }

    public void changePagination() {
        ChangePaginationFDAlert window = new ChangePaginationFDAlert();
        window.show();
        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> {
            numberOfPlayersOnPage = window.getInt();
            window.close();
            update();
        });
    }

}
