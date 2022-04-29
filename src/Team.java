import java.io.Serializable;

public class Team implements Serializable {
    private String teamName;
    private Formula1Driver driverOne;
    private Formula1Driver driverTwo;

    public Team(String teamName, Formula1Driver driverOne, Formula1Driver driverTwo){
        this.teamName = teamName;
        this.driverOne = driverOne;
        this.driverTwo = driverTwo;
    }

    public Team(){}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Formula1Driver getDriverOne() {
        return driverOne;
    }

    public void setDriverOne(Formula1Driver driverOne) {
        this.driverOne = driverOne;
    }

    public Formula1Driver getDriverTwo() {
        return driverTwo;
    }

    public void setDriverTwo(Formula1Driver driverTwo) {
        this.driverTwo = driverTwo;
    }

    @Override
    public String toString() {
        return teamName ;
    }
}