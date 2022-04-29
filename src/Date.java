import java.io.Serializable;
import java.util.Objects;

public class Date implements Serializable {
    private int Day;
    private int Month;
    private int Year;

    public Date (int Day, int Month, int Year){
        this.Day = Day;
        this.Month = Month;
        this.Year= Year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return Day == date.Day && Month == date.Month && Year == date.Year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Day, Month, Year);
    }

    public int getDay() {
        return Day;
    }

    public void setDay(int day) {
        this.Day = day;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int Month) {
        this.Month = Month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        this.Year = year;
    }

    @Override
    public String toString() {
        return Day +"-"+ Month +"-"+ Year;
    }
}
