package sample.model;

import java.util.Date;


public class PlayerModel {

    private String firstName = "не указано";
    private String middleName = "не указано";
    private String lastName = "не указано";
    private Date birthDate;
    private String teamName = "не указано";
    private String homeTown = "не указано";
    private SquadEnum squad;
    private String position = "не указано";

    public PlayerModel() {
    }

    public PlayerModel(String firstName, String middleName, String lastName, Date birthDate,
                       String teamName, String homeTown,
                       SquadEnum squad, String position) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.squad = squad;
        this.teamName = teamName;
        this.homeTown = homeTown;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public SquadEnum getSquad() {
        return squad;
    }

    public String getPosition() {
        return position;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public void setSquad(SquadEnum squad) {
        this.squad = squad;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
