import java.io.Serializable;

public class Formula1Driver implements Serializable {
    private String DriverName;
    private String DriverLocation;
    private Team DriverTeam;
    private int DriversFirstPositions;
    private int DriversSecondPositions;
    private int DriversThirdPositions;
    private int DriversPoints;
    private int NumberOfRacesDriverParticipated;

    public Formula1Driver(String DriverName, String DriverLocation, Team DriverTeam, int DriversFirstPositions, int DriversSecondPositions, int DriversThirdPositions, int DriversPoints, int NumberOfRacesDriverParticipated){
        this.DriverName=DriverName;
        this.DriverLocation=DriverLocation;
        this.DriverTeam=DriverTeam;
        this.DriversFirstPositions=DriversFirstPositions;
        this.DriversSecondPositions=DriversSecondPositions;
        this.DriversThirdPositions=DriversThirdPositions;
        this.DriversPoints=DriversPoints;
        this.NumberOfRacesDriverParticipated=NumberOfRacesDriverParticipated;
    }
    public Formula1Driver(){}

    public String getName() {
        return DriverName;
    }

    public void setName(String DriverName) {
        this.DriverName = DriverName;
    }

    public String getLocation() {
        return DriverLocation;
    }

    public void setLocation(String DriverLocation) {
        this.DriverLocation = DriverLocation;
    }

    public Team getTeam() {
        return DriverTeam;
    }

    public void setTeam(Team DriverTeam) {
        this.DriverTeam = DriverTeam;
    }

    public int getFirstPositions() {
        return DriversFirstPositions;
    }

    public void setFirstPositions(int DriversFirstPositions) {
        this.DriversFirstPositions = DriversFirstPositions;
    }

    public int getSecondPositions() {
        return DriversSecondPositions;
    }

    public void setSecondPositions(int DriversSecondPositions) {
        this.DriversSecondPositions = DriversSecondPositions;
    }

    public int getThirdPositions() {
        return DriversThirdPositions;
    }

    public void setThirdPositions(int DriversThirdPositions) {
        this.DriversThirdPositions = DriversThirdPositions;
    }

    public int getPoints() {
        return DriversPoints;
    }

    public void setPoints(int DriversPoints) {
        this.DriversPoints = DriversPoints;
    }

    public int getNumOfRacesParticipated() {
        return NumberOfRacesDriverParticipated;
    }

    public void setNumOfRacesParticipated(int NumberOfRacesDriverParticipated) {
        this.NumberOfRacesDriverParticipated = NumberOfRacesDriverParticipated;
    }

    @Override
    public String toString() {
        return  DriverName;
    }

    public String toStr() {
        return  " | Driver Name = " + DriverName +
                " | Driver's location = " + DriverLocation +
                " | Team = " + DriverTeam.getTeamName() +
                " | First Positions = " + DriversFirstPositions +
                " | Second Positions = " + DriversSecondPositions +
                " | Third Positions = " + DriversThirdPositions +
                " | Points = " + DriversPoints +
                " | Races Participated = " + NumberOfRacesDriverParticipated;
    }
}
