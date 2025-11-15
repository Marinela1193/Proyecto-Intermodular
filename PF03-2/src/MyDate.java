//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MyDate {
    public static final String ERR_INVALID_YEAR = "Year value not valid";
    public static final String ERR_INVALID_MONTH = "Month value not valid";
    public static final String ERR_INVALID_DAY = "Day value not valid";
    public static final String ERR_INVALID_DATE = "Invalid date";
    private Months month;
    private Days day;

    public MyDate(int i, Months months, int i1) {
    }

    public MyDate() {

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
    }

    public Days getDay(){
        return this.day;
    }

    //declaramos los años para recogerlos en los testers

    public int year;

    public void setYear(int year) {
    }

    public int getYear(){
        return this.year;
    }
}