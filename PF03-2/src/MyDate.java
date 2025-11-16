//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MyDate {
    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";
    private Months month;
    private int day;
    private int year;

    public MyDate(int day, Months month, int year) {
        validateYear(year);
        validateDay(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public MyDate() {

    }

    private void validateYear(int year) {
        if (year < 0)
            throw new IllegalArgumentException(ERR_INVALID_YEAR);
    }

    private void validateMonth(int month){
        if (month < 0 || month > 12){
            throw new IllegalArgumentException(ERR_INVALID_MONTH);
        }
    }

    private void validateDay(int day, Months month, int year){
        if (day < 1 || day > 31)
            throw new IllegalArgumentException(ERR_INVALID_DAY);

        int max = daysInMonth(month, year);

        if (day > max)
            throw new IllegalArgumentException(ERR_INVALID_DATE);
    }
    private int daysInMonth(Months month, int year){
        return switch (month) {
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            case FEBRUARY -> isLeapYear(year) ? 29 : 28;
            default -> 31;
        };
    }

    private boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    public enum Months {
        JANUARY(1),
        FEBRUARY(2),
        MARCH(3),
        APRIL(4),
        MAY(5),
        JUNE(6),
        JULY(7),
        AUGUST(8),
        SEPTEMBER(9),
        OCTOBER(10),
        NOVEMBER(11),
        DECEMBER(12);

        public final int monthNumber;

        private Months(int monthNumber) {
            this.monthNumber = monthNumber;
        }

        public static Months toMonth( int monthNumber ) {
            for (Months m : values())
                if (m.monthNumber == monthNumber)
                    return m;
            return null;
        }
    }

    public void setMonth(Months month) {
        validateMonth(month.ordinal());

        if (this.day > daysInMonth(month, this.year))
            throw new IllegalArgumentException(ERR_INVALID_MONTH);

        this.month = month;
    }

    public Months getMonth(){
        return  this.month;
    }



    public enum Days {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);

        public final int dayNumber;

        private Days (int dayNumber){
            this.dayNumber = dayNumber;
        }
        public static Days toDay( int dayNumber ) {
            for (Days d : values())
                if (d.dayNumber == dayNumber)
                    return d;
            return null;
        }
    }

    public void setDay(int day) {
        if (day < 1 || day > 31)
            throw new IllegalArgumentException(ERR_INVALID_DAY);

        if (this.month != null && this.year != 0) {
            if (day > daysInMonth(this.month, this.year))
                throw new IllegalArgumentException(ERR_INVALID_DAY);
        }
        this.day = day;
    }

    public int getDay(){
        return this.day;
    }

    public void setYear(int year) {
        validateYear(year);

        if (this.month == Months.FEBRUARY && this.day == 29 && !isLeapYear(year))
            throw new IllegalArgumentException(ERR_INVALID_YEAR);

        this.year = year;
    }

    public int getYear(){
        return this.year;
    }
}