package month_printer;

public class MPDemo {
    public static void main(String[] args) {

        MonthPrinter printer = MonthPrinter.getInstance();
        printer.printMonth(2020, 5);
        printer.printMonth(1920, 7);
        printer.printMonth(1976, 12);

        //expecting exception for wrong year
        printer.printMonth(1762, 2);
        //expecting exception for wrong month
        printer.printMonth(2000, 20);
    }
}
