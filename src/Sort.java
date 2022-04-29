import java.util.Comparator;

public class Sort {
    public Comparator<Formula1Driver> pointsSortDesc = new Comparator<Formula1Driver>() {
        @Override
    public int compare(Formula1Driver other1, Formula1Driver other2) {
        if (other1.getPoints() < other2.getPoints()) {
            return 1;
        } else if (other1.getPoints() > other2.getPoints()) {
            return -1;
        } else if (other1.getPoints() == other2.getPoints()) {
            int fPositionCount1 = other1.getFirstPositions();
            int fPositionCount2 = other2.getFirstPositions();
            if (fPositionCount1<fPositionCount2) {
                return 1;
            } else if (fPositionCount1>fPositionCount2) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
    };

    public Comparator<Formula1Driver> pointsSortAsc = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver other1, Formula1Driver other2) {
            if (other1.getPoints() > other2.getPoints()) {
                return 1;
            } else if (other1.getPoints() < other2.getPoints()) {
                return -1;
            } else if (other1.getPoints() == other2.getPoints()) {
                int fPositionCount1 = other1.getFirstPositions();
                int fPositionCount2 = other2.getFirstPositions();
                if (fPositionCount1>fPositionCount2) {
                    return 1;
                } else if (fPositionCount1<fPositionCount2) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    };

    public Comparator<Formula1Driver> firstPositionSort = new Comparator<Formula1Driver>() {
        @Override
        public int compare(Formula1Driver other1, Formula1Driver other2) {
            if (other1.getFirstPositions() < other2.getFirstPositions()) {
                return 1;
            } else if (other1.getFirstPositions() > other2.getFirstPositions()) {
                return -1;
            } else if (other1.getFirstPositions() == other2.getFirstPositions()) {
                int points1 = other1.getFirstPositions();
                int points2 = other2.getFirstPositions();
                if (points1<points2) {
                    return 1;
                } else if (points1>points2) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    };

    public Comparator<Race> raceDateSort = new Comparator<Race>() {
        @Override
        public int compare(Race other1, Race other2) {
            if (other1.getRaceDate().getYear() > other2.getRaceDate().getYear()) {
                return 1;
            } else if (other1.getRaceDate().getYear() < other2.getRaceDate().getYear()) {
                return -1;
            } else if (other1.getRaceDate().getYear() == other2.getRaceDate().getYear()) {
                if (other1.getRaceDate().getMonth() < other2.getRaceDate().getMonth()) {
                    return 1;
                } else if (other1.getRaceDate().getMonth() > other2.getRaceDate().getMonth()) {
                    return -1;
                } else if(other1.getRaceDate().getMonth() == other2.getRaceDate().getMonth()){
                    if(other1.getRaceDate().getDay() < other2.getRaceDate().getDay()){
                        return 1;
                    }else if (other1.getRaceDate().getDay() > other2.getRaceDate().getDay()){
                        return -1;
                    }else{
                        return 0;
                    }
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }
    };


}