/**
 * Class Month creates object for the month specified within a specified year with all associated
 * days in an array.
 *
 * @author Alexa Hankins
 * @author Wenting Zheng
 * @author Iain Dixon
 */
public class Month {
    //Private instance variables
    private int monthNumber;
    private int daysInMonth;
    private int year;
    private String monthName;
    private int [] monthLength = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private String [] months = {"","January","February", "March", "April", "May", "June", "July",
                                "August", "September", "October", "November", "December"}; 
    private Day [] days= null;

    /**
     * Constructor for the Month class.
     * @param monthNumber
     * @param year
     * @param isLeapYear
     */
    public Month(int monthNumber, int year, boolean isLeapYear) {
        this.monthNumber = monthNumber;
        this.year = year;
        if(monthNumber <= 12 && monthNumber >= 1) {
            monthName = months[monthNumber];
            daysInMonth = monthLength[monthNumber];
        } else {
            throw new IllegalArgumentException("Invalid Month Number");
        }
        if(isLeapYear && monthNumber == 2) {
            daysInMonth++;
        }
        days = new Day[daysInMonth];
        int w = 0;
        int x = 0;
        int z = 0;
        int day_of_week = 0;
		
	    for(int i = 1; i <= daysInMonth; i++){
	      w = year - (14 - monthNumber) / 12;
          x = w + w / 4 - w / 100 + w /400;
          z = monthNumber + 12 * ((14 - monthNumber) / 12) - 2;
          day_of_week = (i + x + (31 * z) / 12) % 7;
		  days[i-1] = new Day(i, day_of_week);
		}
		
    }

    /**
     * getDaysInMonth returns int for how many days there are in the month.
     * @return
     */
    public int getDaysInMonth() {
        return daysInMonth;
    }

    /**
     * getDay returns day object for given day.
     * @param day Number of day entered.
     * @return Day object for entered day.
     */
    public Day getDay(int day) {
        return days[day-1];
    }

    /**
     * toString returns String of month with events.
     * @return String containing month with events.
     */
	public String toString(){
	  String s = "", message = "";

	  s += "\t\t\t" + months[monthNumber] + "\n";
	  s += "Sun\tMon\tTues\tWed\tThurs\tFri\tSat\n";
	  for(int i = 1; i <= daysInMonth; i++){
		if(i == 1){
		  for(int j = 0; j < days[i-1].getDayOfWeek(); j++){
		    s += "\t";
	      }
		}
		s += i + "\t";
		if(days[i-1].getDayOfWeek() == 6){
		  s += "\n";
		}
		if(!days[i-1].getEvent().equals("")) {
		    message += monthName + " " + i + ": " + days[i-1].getEvent() + "\n";
        }
	  }
	  return s + message;
	}
}   
