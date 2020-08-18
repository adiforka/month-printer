package month_printer;

public class MPDemo {
    public static void main(String[] args) {

        MonthPrinter printer = MonthPrinter.getInstance(1983, 12);
        printer.printMonth();

        printer = MonthPrinter.getInstance(1999, 12);
        printer.printMonth();

        //expecting exception for wrong year
        printer = MonthPrinter.getInstance(1799, 12);
        printer.printMonth();

        //expecting exception for wrong month
        printer = MonthPrinter.getInstance(2000, 20);
        printer.printMonth();
    }
}
