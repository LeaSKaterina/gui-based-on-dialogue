package sample.view;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.model.PlayerModel;
import sample.model.SquadEnum;

import java.util.Date;

import javafx.scene.control.TableView;

public class TableOfPlayers extends TableView {

    final private TableColumn<PlayerModel, String> fullNameModelTableColumn;
    final private TableColumn<PlayerModel, Date> birthDateTableColumn;
    final private TableColumn<PlayerModel, String> teamNameTableColumn;
    final private TableColumn<PlayerModel, String> homeTownTableColumn;
    final private TableColumn<PlayerModel, SquadEnum> squadTableColumn;
    final private TableColumn<PlayerModel, String> position;

    public TableColumn<PlayerModel, String> getFullNameModelTableColumn() {
        return fullNameModelTableColumn;
    }

    public TableColumn<PlayerModel, Date> getBirthDateTableColumn() {
        return birthDateTableColumn;
    }

    public TableColumn<PlayerModel, String> getTeamNameTableColumn() {
        return teamNameTableColumn;
    }

    public TableColumn<PlayerModel, String> getHomeTownTableColumn() {
        return homeTownTableColumn;
    }

    public TableColumn<PlayerModel, SquadEnum> getSquadTableColumn() {
        return squadTableColumn;
    }

    public TableColumn<PlayerModel, String> getPosition() {
        return position;
    }

    public TableOfPlayers() {
        setMinHeight(600);

        fullNameModelTableColumn = new TableColumn<>("ФИО");
        //Creates a default PropertyValueFactory to extract the value from a given TableView row item reflectively, using the given property name.
        fullNameModelTableColumn.setCellValueFactory(new PropertyValueFactory("fullName"));
        fullNameModelTableColumn.setPrefWidth(300);

        birthDateTableColumn = new TableColumn<>("Дата рождения");
        birthDateTableColumn.setCellValueFactory(new PropertyValueFactory("birthDate"));
        birthDateTableColumn.setPrefWidth(150);

        teamNameTableColumn = new TableColumn<>("Футбольная команда");
        teamNameTableColumn.setCellValueFactory(new PropertyValueFactory("teamName"));
        teamNameTableColumn.setPrefWidth(200);

        homeTownTableColumn = new TableColumn<>("Домашний город");
        homeTownTableColumn.setCellValueFactory(new PropertyValueFactory("homeTown"));
        homeTownTableColumn.setPrefWidth(200);

        squadTableColumn = new TableColumn<>("Состав");
        squadTableColumn.setCellValueFactory(new PropertyValueFactory("squad"));
        squadTableColumn.setPrefWidth(150);

        position = new TableColumn<>("Позиция");
        position.setCellValueFactory(new PropertyValueFactory("position"));
        position.setPrefWidth(150);

        getColumns().addAll(fullNameModelTableColumn, birthDateTableColumn, teamNameTableColumn, homeTownTableColumn, squadTableColumn, position);
    }
}
