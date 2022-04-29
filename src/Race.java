import java.io.Serializable;

public class Race implements Serializable {
    private Date RaceDate ;
    private Formula1Driver firstPositions;
    private Formula1Driver secondPositions;
    private Formula1Driver thirdPositions;
    private Formula1Driver forthPositions;
    private Formula1Driver fifthPositions;
    private Formula1Driver sixthPositions;
    private Formula1Driver seventhPositions;
    private Formula1Driver eighthPosition;
    private Formula1Driver ninthPositions;
    private Formula1Driver tenthPositions;


    public Race(Date matchDate, Formula1Driver firstPositions, Formula1Driver secondPositions, Formula1Driver thirdPositions, Formula1Driver forthPositions,
    Formula1Driver fifthPositions, Formula1Driver sixthPositions, Formula1Driver seventhPositions, Formula1Driver eighthPosition, Formula1Driver ninthPositions, Formula1Driver tenthPositions){
        this.RaceDate=matchDate;
        this.firstPositions=firstPositions;
        this.secondPositions=secondPositions;
        this.thirdPositions=thirdPositions;
        this.forthPositions=forthPositions;
        this.fifthPositions=fifthPositions;
        this.sixthPositions=sixthPositions;
        this.seventhPositions=seventhPositions;
        this.eighthPosition=eighthPosition;
        this.ninthPositions=ninthPositions;
        this.tenthPositions=tenthPositions;
    }

    public Race(){}

    public Date getRaceDate() {
        return RaceDate;
    }

    public void setRaceDate(Date matchDate) {
        this.RaceDate = matchDate;
    }

    public Formula1Driver getFirstPosition() {
        return firstPositions;
    }

    public void setFirstPosition(Formula1Driver firstPositions) {
        this.firstPositions = firstPositions;
    }

    public Formula1Driver getSecondPosition() {
        return secondPositions;
    }

    public void setSecondPosition(Formula1Driver secondPositions) {
        this.secondPositions = secondPositions;
    }

    public Formula1Driver getThirdPosition() {
        return thirdPositions;
    }

    public void setThirdPosition(Formula1Driver thirdPositions) {
        this.thirdPositions = thirdPositions;
    }

    public Formula1Driver getForthPosition() {
        return forthPositions;
    }

    public void setForthPosition(Formula1Driver forthPositions) {
        this.forthPositions = forthPositions;
    }

    public Formula1Driver getFifthPosition() {
        return fifthPositions;
    }

    public void setFifthPosition(Formula1Driver fifthPositions) {
        this.fifthPositions = fifthPositions;
    }

    public Formula1Driver getSixthPosition() {
        return sixthPositions;
    }

    public void setSixthPosition(Formula1Driver sixthPositions) {
        this.sixthPositions = sixthPositions;
    }

    public Formula1Driver getSeventhPosition() {
        return seventhPositions;
    }

    public void setSeventhPosition(Formula1Driver seventhPositions) {
        this.seventhPositions = seventhPositions;
    }

    public Formula1Driver getEighthPosition() {
        return eighthPosition;
    }

    public void setEighthPosition(Formula1Driver eighthPosition) {
        this.eighthPosition = eighthPosition;
    }

    public Formula1Driver getNinthPosition() {
        return ninthPositions;
    }

    public void setNinthPosition(Formula1Driver ninthPositions) {
        this.ninthPositions = ninthPositions;
    }

    public Formula1Driver getTenthPosition() {
        return tenthPositions;
    }

    public void setTenthPosition(Formula1Driver tenthPositions) {
        this.tenthPositions = tenthPositions;
    }

    @Override
    public String toString() {
        return  " | matchDate =" + RaceDate+
                " | firstPositions = " + firstPositions+
                " | secondPositions = " + secondPositions+
                " | thirdPositions = " + thirdPositions+
                " | forthPositions = " + forthPositions+
                " | fifthPositions = " + fifthPositions +
                " | sixthPositions = " + sixthPositions+
                " | seventhPositions = " + seventhPositions +
                " | eighthPosition = " + eighthPosition +
                " | ninthPositions = " + ninthPositions +
                " | tenthPositions = " + tenthPositions ;
    }
}
