package Discount;

import java.util.Date; // import the Date class
import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;

/**
 * user holding name, membership and membership start date
 */
public class User {
    private String membership;
    private String name;
    Date memberStart;

    public User(){
        this.membership = "new";
        this.name = "noname";
        this.memberStart = new Date(); // Create a date object
    }

    public User(String membership){
        this.membership = membership;
        this.name = "noname";
        this.memberStart = new Date(); // Create a date object
    }

    public User(String membership,String name){
        this.membership = membership;
        this.name = name;
        this.memberStart = new Date(); // Create a date object
    }
    public User(String membership,String name,Date memberStart){
        this.membership = membership;
        this.name = name;
        this.memberStart = memberStart; // Create a date object
    }

    public String getName(){
        return name;
    }
    public String getMembership(){
        return membership;
    }
    public int takeMemberYear(){
        Date temp = new Date();
        return getDiffYears(memberStart,temp);
    }

    /**
     * calculate membership year
     * @param first starting date
     * @param last nowadays
     * @return year
     */
    private static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    /**
     *
     * @return membership value
     */
    public int discount(){
        if(membership.equals("gold")){
            return 0;
        }
        else if(membership.equals("silver")){
            return 1;
        }
        else if(membership.equals("affiliate")){
            return 2;
        }
        else if(takeMemberYear()>=2){
            return 3;
        }
        else
            return 4;

    }
}
