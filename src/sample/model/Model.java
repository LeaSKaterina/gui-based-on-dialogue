package sample.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.view.FDDatePicker;

import java.util.Date;

public class Model {
    private ObservableList<PlayerModel> listOfPlayers = FXCollections.observableArrayList();

    public ObservableList<PlayerModel> getListOfPlayers() {
        return listOfPlayers;
    }

    public Model() {}

    public void setListOfPlayers(ObservableList<PlayerModel> newList){
        listOfPlayers = newList;
    }

    private boolean matchNameOrBirthDate(PlayerModel player, String firstName, String middleName, String lastName, Date birthDate) {
        return ((player.getFirstName().equals(firstName) && !firstName.equals("не указано")) ||
                (player.getMiddleName().equals(middleName) && !middleName.equals("не указано")) ||
                (player.getLastName().equals(lastName) && !lastName.equals("не указано")))
                && (player.getBirthDate().equals(birthDate) && birthDate != FDDatePicker.getDefaultDate());
    }

    private boolean matchTeamNameOrHomeTown(PlayerModel player, String teamName, String homeTown) {
        return (player.getTeamName().equals(teamName) && !teamName.equals("не указано"))
                || (player.getHomeTown().equals(homeTown) && !homeTown.equals("не указано"));
    }

    private boolean matchSquadOrPosition(PlayerModel player, SquadEnum squad, String position) {
        return (player.getSquad().equals(squad) && squad != SquadEnum.defaultSquad)
                || (player.getPosition().equals(position) && !position.equals("не указано"));
    }

    public void addPlayer(PlayerModel newPlayer) {
        listOfPlayers.add(newPlayer);
    }


    public int deletePlayersWith(String firstName, String middleName, String lastName, Date birthDate) {
        int amount = 0;
        for (int i = 0; i < listOfPlayers.size(); i++) {
            if (matchNameOrBirthDate(listOfPlayers.get(i), firstName, middleName, lastName, birthDate)) {
                listOfPlayers.remove(i);
                i--;
                amount++;
            }
        }
        return amount;
    }

    public int deletePlayersWith(String teamName, String homeTown) {
        int amount = 0;
        for (int i = 0; i < listOfPlayers.size(); i++) {
            if (matchTeamNameOrHomeTown(listOfPlayers.get(i), teamName, homeTown)) {
                listOfPlayers.remove(i);
                i--;
                amount++;
            }
        }
        return amount;
    }

    public int deletePlayersWith(SquadEnum squad, String position) {
        int amount = 0;
        for (int i = 0; i < listOfPlayers.size(); i++) {
            if (matchSquadOrPosition(listOfPlayers.get(i), squad, position)) {
                listOfPlayers.remove(i);
                i--;
                amount++;
            }
        }
        return amount;
    }


    public ObservableList<PlayerModel> getPlayersWith(String firstName, String middleName, String lastName, Date birthDate) {
        ObservableList<PlayerModel> list = FXCollections.observableArrayList();

        for (PlayerModel player : listOfPlayers) {
            if (matchNameOrBirthDate(player, firstName, middleName, lastName, birthDate)) {
                list.add(player);
            }
        }
        return list;
    }

    public ObservableList<PlayerModel> getPlayersWith(String teamName, String homeTown) {
        ObservableList<PlayerModel> list = FXCollections.observableArrayList();

        for (PlayerModel player : listOfPlayers) {
            if (matchTeamNameOrHomeTown(player, teamName, homeTown)) {
                list.add(player);
            }
        }
        return list;
    }

    public ObservableList<PlayerModel> getPlayersWith(SquadEnum squad, String position) {
        ObservableList<PlayerModel> list = FXCollections.observableArrayList();

        for (PlayerModel player : listOfPlayers) {
            if (matchSquadOrPosition(player, squad, position)) {
                list.add(player);
            }
        }
        return list;
    }
}
