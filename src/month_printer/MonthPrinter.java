package month_printer;

//prints input month to console
public class MonthPrinter {

    public static MonthPrinter getInstance() {
        return new MonthPrinter();
    }

    public void printMonth(int year, int month) {

        validateInput(year, month);
        printMonthMeader(year, month);
        printMonthBody(year, month);
        System.out.println();
    }

    private void validateInput(int year, int month) {
        if (year < 1800) {
            throw new IllegalArgumentException("Year must not be below 1800");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in the range of 1 - 12 (Jan = 1, Feb = 2 etc.)");
        }
    }

    private void printMonthMeader(int year, int month) {
        System.out.println(getMonthName(month) + " " + year);
        System.out.println("------------------------------");
        System.out.printf("%3s  %3s  %3s  %3s  %3s  %3s  %3s\n",
                "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
    }

    private void printMonthBody(int year, int month) {

        var totalDays = getTotalDays(year, month);
        var startDayIndex = getStartDay(totalDays);
        var numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        for (int i = 0; i < startDayIndex; i++) {
            System.out.print("     ");
        }

        int i;
        for (i = 1; i <= numberOfDaysInMonth; i++) {
            if ((i + startDayIndex) % 7 == 0) {
                System.out.printf("%3d\n", i);
            } else
                System.out.printf("%3d  ", i);
        }
    }

    private String getMonthName(int month) {
        return switch (month) {
            case 1 -> "JANUARY";
            case 2 -> "FEBRUARY";
            case 3 -> "MARCH";
            case 4 -> "APRIL";
            case 5 -> "MAY";
            case 6 -> "JUNE";
            case 7 -> "JULY";
            case 8 -> "AUGUST";
            case 9 -> "SEPTEMBER";
            case 10 -> "OCTOBER";
            case 11 -> "NOVEMBER";
            case 12 -> "DECEMBER";
            default -> throw new IllegalArgumentException(
                    "Enter a value between 1 and 12");
        };
    }

    private int getStartDay(int totalDays) {
        return (3 + totalDays) % 7;
    }

    private int getTotalDays(int year, int month) {
        int totalDays = 0;
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                totalDays += 366;
            } else totalDays += 365;
        }

        for (int i = 1; i < month; i++) {
            totalDays += getNumberOfDaysInMonth(year, i);
        }
        return totalDays;
    }

    private int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else return (month == 2 && isLeapYear(year)) ? 29 : 28;
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
