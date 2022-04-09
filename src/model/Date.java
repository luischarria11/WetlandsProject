package model;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int newDay, int newMonth, int newYear) {
        day = newDay;
        month = newMonth;
        year = newYear;
    }

    public String toString() {
        return day + "/" + month + "/" + year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int newDay) {
        day = newDay;
    }

    public void setMonth(int newMonth) {
        month = newMonth;
    }

    public void setYear(int newYear) {
        year = newYear;
    }
}
