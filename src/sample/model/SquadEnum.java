package sample.model;

//игрок может быть либо в основном, либо в запасном составе
public enum SquadEnum {
    mainSquad("основной"),
    reserveSquad("запасной"),
    defaultSquad("состав не указан");
    private final String value;

    SquadEnum(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static SquadEnum initSquad(String str){
        switch (str){
            case "основной":{
                return mainSquad;
            }
            case "запасной":{
                return reserveSquad;
            }
            default:{
                return defaultSquad;
            }
        }
    }
}
