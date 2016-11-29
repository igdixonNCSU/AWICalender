import java.util.*;

/**
 * Class AWICalendar is the driver class for the calendar program. Presents the user with a menu
 * to choose options from the calendar program.
 *
 * @author Alexa Hankins
 * @author Wenting Zheng
 * @author Iain Dixon
 *
 */
public class AWICalendar {

    /**
     * main method for the AWICalendar Class. Calls all other methods for class and directly
     * prompts the user.
     * @param args String array, is not used in this class.
     */
    public static void main(String [] args) {
        String response = "";
        Scanner console = new Scanner(System.in);
        
        System.out.println("Welcome to the AWICalendar Class");
        
        
        do {
            System.out.println("Please select an action to perform: ");
            System.out.println("    Y - Show full 12-month calendar of the year");
            System.out.println("    M - Show full month");
            System.out.println("    E - Add event to the calendar");
            System.out.println("    Q - Quit calendar");
            System.out.print("Action: ");
            response = console.next();
            if(response.toLowerCase().equals("y")) {
                printYear(console);
            } else if(response.toLowerCase().equals("m")) {
                printMonth(console);
            } else if(response.toLowerCase().equals("e")) {
                addEvent(console);
            } else if(response.toLowerCase().equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Please enter one of the actions above.");
            }
        } while(!response.toLowerCase().equals("q"));
    }

    /**
     * printYear method prints out all of the months for a specified year.
     * @param console Scanner that takes in user input. Created in main method and passed into
     *                printYear method.
     */
    private static void printYear(Scanner console) {
        int year;

        System.out.print("Please enter a year: ");
        year = checkYear(console);

        Year enteredYear = new Year(year);
        System.out.println(enteredYear.toString());
    }

    /**
     * printMonth method prints out a specified month in a specified year.
     * @param console Scanner that takes in user input.
     */
    private static void printMonth(Scanner console) {
        int month, year;
        
        System.out.println("Please enter a month ");
        System.out.print("(1-Jan, 2-Feb, 3-Mar, 4-Apr, 5-May, 6-Jun, 7-Jul, 8-Aug, 9-Sep, 10-Oct, "
                + "11-Nov, 12-Dec): ");
        while(!console.hasNextInt()) {
            System.out.print("Please enter a number for the month: ");
            console.next();
        }
        
        month = console.nextInt();
        
        while(month > 12 || month < 1) {
            System.out.print("Please enter a number between 1 and 12: ");
            month = console.nextInt();
        }

        System.out.print("Please enter a year: ");
        year = checkYear(console);
        Year enteredYear = new Year(year);
        
        Month enteredMonth = new Month(month,year,enteredYear.checkLeapYear());
        System.out.println(enteredMonth.toString());
        
    }

    /**
     * addEvent adds events DOES NOT CURRENTLY WORK
     * @param console Scanner, takes user input.
     */
    private static void addEvent(Scanner console) {
        int day, month, year;
        String message;

        System.out.print("Month of event: ");

        while(!console.hasNextInt()) {
            System.out.print("Please enter a number for the month: ");
            console.next();
        }

        month = console.nextInt();

        while(month > 12 || month < 1) {
            System.out.print("Please enter a number between 1 and 12: ");
            month = console.nextInt();
        }

        System.out.print("Year of event: ");
        year = checkYear(console);
        Year enteredYear = new Year(year);

        Month enteredMonth = new Month(month, year, enteredYear.checkLeapYear());

        System.out.print("Day of event: ");

        while(!console.hasNextInt()) {
            System.out.print("Please enter a number for the day: ");
            console.next();
        }

        day = console.nextInt();

        while(day > enteredMonth.getDaysInMonth() || day < 1) {
            System.out.print("Please enter a number between 1 and " + enteredMonth.getDaysInMonth()
                    + ": ");
            day = console.nextInt();
        }

        Day enteredDay = new Day(day, enteredMonth.getDay(day).getDayOfWeek());

        System.out.print("Description of event: ");
        message = console.next();

        enteredDay.setEvent(message);

    }

    /**
     * checkYear method checks entered year values to ensure that they are valid.
     * @param console Scanner Takes user input.
     * @return int of the year
     */
    private static int checkYear(Scanner console) {
        int year;

        while(!console.hasNextInt()) {
            System.out.print("Please enter a number for the year: ");
            console.next();
        }
        do {
            year = console.nextInt();
            if(year < 1753 ) {
                System.out.print("Please enter a number greater than or equal to 1753: ");
            }
        } while(year < 1753);

        
        return year;
    } 
}
