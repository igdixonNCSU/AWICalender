/**
 * Class Day creates a specified day object with associated date, dayOfWeek, and events.
 *
 * @author Alexa Hankins
 * @author Wenting Zheng
 * @author Iain Dixon
 *
 */
public class Day {
    //Private Instance Variables
    private String event;
    private int date;
    private int dayOfWeek;
    private String [] daysInWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", 
                                    "Friday", "Saturday"};
    
    //Constructor
    
    /**
    * Assigning the values to the instance variables
    * @param date int assigns to the instance variable date
    * @param dayOfWeek String assigns to the instance variable dayOfWeek
    */
    public Day(int date, int dayOfWeek) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        event = "";
    }
    
    //Setters
    
    /**
    * Setting the private instance variable to the paramater
    * @param String event, the name of the event on that particular day
    */
    public void setEvent(String event) {
        this.event = event;
    }
    
    //Getters
    
    /**
    * Getting the variable for the event on that day
    * @return String event, private instance variable
    */
    public String getEvent() {
        return event;
    }

    /**
    * Getting the date for that day
    * @return int date, private instance variable
    */
    public int getDate() {
        return date;
    }
    
    /**
    * Getting the day of the week that the date is located on
    * @return String dayOfWeek, private instance variable
    */
    public int getDayOfWeek() {
        return dayOfWeek;
    }
}
