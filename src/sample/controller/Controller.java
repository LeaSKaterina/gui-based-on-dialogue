package sample.controller;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.model.Model;
import sample.model.PlayerModel;
import sample.parser.WorkWithFile;
import sample.view.*;
import sample.view.FDAlert.*;
import sample.view.FDAlert.FindFDAlert.FindFIOOrBirthDateFDAlert;
import sample.view.FDAlert.FindFDAlert.FindSquadOrPositionFDAlert;
import sample.view.FDAlert.FindFDAlert.FindTeamNameOrHomeTownFDAlert;

public class Controller {
    Model model;
    PaginatedTableController tableController = new PaginatedTableController();

    public Controller() {
        model = new Model();
    }

    public PaginatedTableController getTableController() {
        return tableController;
    }

    public Model getModel() {
        return model;
    }

    public void openDoc(Stage primaryStage) {
        WorkWithFile openEx = new WorkWithFile(primaryStage, this);
        openEx.openDoc();
        tableController.update();
    }

    public void saveDoc(Stage primaryStage) {
        WorkWithFile saveEx = new WorkWithFile(primaryStage, this);
        saveEx.saveDoc();
    }

    public void addPlayer() {

        AddFDAlert addWindow = new AddFDAlert();
        addWindow.show();

        ((Button) addWindow.getDialogPane().lookupButton(addWindow.getButtonTypes().get(0))).setOnAction((ae) -> {
            PlayerModel newPlayer = new PlayerModel(
                    addWindow.getFirstName(), addWindow.getMiddleName(), addWindow.getLastName(), addWindow.getBirthDateValue(),
                    addWindow.getTeamNameValue(), addWindow.getHomeTownValue(),
                    addWindow.getSquadValue(), addWindow.getPositionValue());
            model.addPlayer(newPlayer);
            addWindow.close();
            tableController.update();
        });
    }

    public void deletePlayer() {

        ConditionBox conditionBox = new ConditionBox("Удалить");
        conditionBox.getFIOOrBirthDateBtn().setOnAction((ae) -> deletePlayerByFIOOrBirthDate());
        conditionBox.getTeamNameOrHomeTownBtn().setOnAction((ae) -> deletePlayerByTeamNameOrHomeTown());
        conditionBox.getSquadOrPositionBtn().setOnAction((ae) -> deletePlayerBySquadOrPosition());

        FDAlert deleteWindow = new FDAlert("Удаление игрока", conditionBox);
        deleteWindow.show();

        ((Button) deleteWindow.getDialogPane().lookupButton(deleteWindow.getButtonTypes().get(0))).setOnAction((ae) -> deleteWindow.close());
    }

    private void deletePlayerByFIOOrBirthDate() {

        FIOOrBirthDateFDAlert window = new FIOOrBirthDateFDAlert("Удаление ");
        window.show();

        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> {
            int amount = model.deletePlayersWith(
                    window.getFirstNameValue(),
                    window.getMiddleNameValue(),
                    window.getLastNameValue(),
                    window.getBirthDateValue()
            );
            window.close();
            InformationFDAlert informationWindow = new InformationFDAlert(amount);
            informationWindow.show();
            tableController.update();
        });
    }


    private void deletePlayerByTeamNameOrHomeTown() {

        TeamNameOrHomeTownFDAlert window = new TeamNameOrHomeTownFDAlert("Удаление");
        window.show();

        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> {
            InformationFDAlert informationWindow = new InformationFDAlert(
                    model.deletePlayersWith(window.getTeamNameValue(), window.getHomeTownValue()));
            window.close();
            informationWindow.show();
            tableController.update();
        });
    }

    private void deletePlayerBySquadOrPosition() {

        SquadOrPositionFDAlert window = new SquadOrPositionFDAlert("Удаление");
        window.show();

        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> {
            InformationFDAlert informationWindow = new InformationFDAlert(
                    model.deletePlayersWith(window.getSquadValue(), window.getPositionValue()));
            window.close();
            informationWindow.show();
            tableController.update();
        });
    }


    public void findPlayer() {

        ConditionBox conditionBox = new ConditionBox("Найти");
        conditionBox.getFIOOrBirthDateBtn().setOnAction((ae) -> findPlayerByFIOOrBirthDate());
        conditionBox.getTeamNameOrHomeTownBtn().setOnAction((ae) -> findPlayerByTeamNameOrHomeTown());
        conditionBox.getSquadOrPositionBtn().setOnAction((ae) -> findPlayerBySquadOrPosition());

        FDAlert deleteWindow = new FDAlert("Нахождение игрока", conditionBox);
        deleteWindow.show();

        ((Button) deleteWindow.getDialogPane().lookupButton(deleteWindow.getButtonTypes().get(0))).setOnAction((ae) -> deleteWindow.close());
    }


    private void findPlayerByTeamNameOrHomeTown() {
        FindTeamNameOrHomeTownFDAlert window = new FindTeamNameOrHomeTownFDAlert();
        window.show();
        window.setOnActionFindButton((ae) -> {
            ObservableList<PlayerModel> list = model.getPlayersWith(window.getTeamNameValue(), window.getHomeTownValue());
            if (list.size() == 0) {
                InformationFDAlert informationWindow = new InformationFDAlert(0);
                informationWindow.show();
            } else {
                window.showTheTable(list);
            }
        });
        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> window.close());
    }


    private void findPlayerByFIOOrBirthDate() {
        FindFIOOrBirthDateFDAlert window = new FindFIOOrBirthDateFDAlert();
        window.show();
        window.setOnActionFindButton((ae) -> {
            ObservableList<PlayerModel> list = model.getPlayersWith(
                    window.getFirstNameValue(),
                    window.getMiddleNameValue(),
                    window.getLastNameValue(),
                    window.getBirthDateValue()
            );
            if (list.size() == 0) {
                InformationFDAlert informationWindow = new InformationFDAlert(0);
                informationWindow.show();
            } else {
                window.showTheTable(list);
            }
        });
        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> window.close());
    }

    private void findPlayerBySquadOrPosition() {
        FindSquadOrPositionFDAlert window = new FindSquadOrPositionFDAlert();
        window.show();
        window.setOnActionFindButton((ae) -> {
            ObservableList<PlayerModel> list = model.getPlayersWith(window.getSquadValue(), window.getPositionValue());
            if (list.size() == 0) {
                InformationFDAlert informationWindow = new InformationFDAlert(0);
                informationWindow.show();
            } else {
                window.showTheTable(list);
            }
        });
        ((Button) window.getDialogPane().lookupButton(window.getButtonTypes().get(0))).setOnAction((ae) -> window.close());
    }

}
