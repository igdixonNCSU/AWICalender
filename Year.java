/**
 * Class Year creates a specified year object with all of the associated months in an array.
 *
 * @author Alexa Hankins
 * @author Wenting Zheng
 * @author Iain Dixon
 *
 */
public class Year {
    //Private Instance Variables
    private boolean isLeapYear;
    private int yearNumber;
    private Month[] months = new Month[12];

    /**
     * Year constructor method creates the Year object based on a given yearNumber.
     * @param int yearNumber int for given year.
     */
    public Year(int yearNumber) {
        if(yearNumber < 1753) {
            throw new IllegalArgumentException("The year must be greater than or equal to 1753.");
        }
        this.yearNumber = yearNumber;
        isLeapYear = checkLeapYear();
        for(int i = 0; i < months.length; i++) {
            months[i] = new Month(i+1, yearNumber, isLeapYear);
        }
    }

    /**
     * checkLeapYear method checks to see if the given year is a leap year.
     * @return boolean, true if it is a leap year. False if it is not.
     */
    public boolean checkLeapYear() {
        if(yearNumber % 4 == 0 && yearNumber % 100 == 0 && yearNumber % 400 == 0) {
            return true;
        } else if (yearNumber % 4 == 0 && yearNumber % 100 != 0) {
            return true;
        }
        return false;
    }

    /**
     * toString method returns the year as a String.
     * @return String s, of entire year.
     */
    public String toString() {
        String s = "";
        for(int i = 0; i < months.length; i++) {
            s += months[i].toString();
            s += "\n\n";
        }
        return s;
    }

}
