package com.davegreen;

import java.util.Calendar;
import java.util.Date;

public class Main
{

    public static void main(String[] args)
    {
	    String s = String.format("%,d", 1000000000);                                // As can be seen in both of these formatting examples, the % (percentage) sign is the
        System.out.println(s);                                                      // point in the first argument where we are declaring that what follows is that which we
                                                                                    // want formatted, and the actual thing that is to be formatted is the second argument
        String string = String.format("I have %.2f bugs to fix.", 476578.09876);    // passed to the String.format() method i.e. in this example the number.
        System.out.println(string);                                                 // The .2f means format the number to a  floating point number with the precision of two
                                                                                    // decimal places, we can also add in commas as in the first example.
    
        String string2 = String.format("I now have %,.2f bugs to fix.", 542687.04568);
        System.out.println(string2);                                                // As you can see commas have been added to the outputted code, making it neater.
        
        
                                                                                    // Look up String.format() syntax to understand why and how the compiler knows what is and
                                                                                    // what is not part of the string literal, string format has its own little language syntax
                                                                                    // some of which you've seen already:
                                                                                    // %,d
                                                                                    // %.2f
                                                                                    // %,.2f
                                                                                    // See page 298 of HeadFirst Java.
        
        String string3 = String.format("Oh my, I now have %.2f, bugs to fix.", 856324.45265);       // Here it can been seen that it is necessary to place the commas in the
        System.out.println(string3);                                                                // correct place or you will not get the formatting you so wish.
    
        String string4 = String.format("Oh my, I now have %,.2f bugs to fix.", 856324.45265);       // Comma now in the correct place achieves the desired result of placing the
        System.out.println(string4);                                                                // comma's in the number to format it.
        
        int one = 20456654;
        double two = 100567890.248907;
        
        String string5 = String.format("The rank is %,d out of %,.2f", one, two);       // Now we two numbers that are passed to the formatter as variables and each is formatted in the
        System.out.println(string5);                                                    // order the are seen, i.e. %,d formats the variable "one", and %,.2f formats the variable "two".
        
        
        String date = String.format("%tc", new Date());                                 // We now move on from number formatting to date and time formatting, as can be see the
        System.out.println(date);                                                       // % (percent) sign remains as the "insert formatting here" identifier, however the language
                                                                                        // syntax now changes with "tc" being use to display the complete date and time.
        
        String justTime = String.format("%tr", new Date());                             // "tr" being the syntax to format in order to display just the time.
        System.out.println(justTime);
        
        Date today = new Date();                                                        // More formatting using different formatting syntax language to give different output results
        String todaysDate = String.format("%tA, %tB %td", today, today, today);         // the arguments are however duplicated which isn't ideal but is solved below.
        System.out.println(todaysDate);
    
        Date todayAgain = new Date();
        String todaysDateAgain = String.format("%tA, %<tB %<td", today);                // The angle braces used in the formatting tell the formatter to use the same argument again
        System.out.println(todaysDateAgain);                                            // for this next piece of formatting to be done, thus we can format the same argument in many
                                                                                        // different ways, this also prevent us having duplicated code.
        
        // Up to now we have been using java.util.Date;, this is fine is we want to say "Give me NOW", but as your about to see from now on we will be using
        // java.util.GregorianCalendar which is suitable for all our date manipulation needs, also most of the Date classes methods have been deprecated (obsolete, superseded, out of date)
        
        // It is best to note that the Calendar class is abstract and so we will be using a concrete subclass.
    
        //Calendar calendar = new Calendar();     // As can be seen this wont work, we cant create an instance of an abstract class.
        
        Calendar cal = Calendar.getInstance();      // Here we are accessing the static method getInstance which calls the static method createCalendar and then returns an
                                                    // instance of a concrete subclass of the calender class which is by extension/polymorphically able to use all of the calendar classes.
                                                    // methods, ultimately this returns me information based of a default value of my current time zone.
    
        System.out.println("#####  CALENDAR START  #####");
        
        cal.set(1970, 0, 1, 01, 00, 00);          // Setting the time, this is the date the internal calendar is set to Jan 1st 1970, 01:00:00. (Epoch)
        long day1 = cal.getTimeInMillis();                                               // getTimeInMillis then calculates the amount of time passed between that start date and whatever date
                                                                                         // i might change it to.
        System.out.println(day1);                                                       // Here we print out the day1 result which is a reasonably low number due to being right on the set
                                                                                        // start date.
        day1 += 1000 * 60 * 60;                                                         // Here we area adding an hours worth of millis and then updating the timeInMillis using the
        cal.setTimeInMillis(day1);                                                      // setTimeInMillis method.
        
        System.out.println("New hour " + cal.get(cal.HOUR_OF_DAY));                     // HOUR OF THE DAY gets the hour of the day based on a 24 hour clock, after adding an hours worth of
                                                                                        // time onto our clock we are now at 02:00:00 in the morning and so the printed out result is "2".
        cal.add(cal.DATE, 35);                                                  // Here we add 35 days on to current date.
        System.out.println("Add 35 days " + cal.getTime());                            // Here we call the new time and date.
        cal.roll(cal.DATE, 35);                                                 // Here we roll 35 days forward in time notice that the month DOES NOT change though.
        System.out.println("Roll 35 days " + cal.getTime());                           // Although the days have been accurately rolled forward 35, we must remember that the month is inaccurate.
        cal.set(cal.DATE, 1);                                                          // Here we are simply setting the date back to the first.
        System.out.println("Set to 1 " + cal.getTime());                               // Again we print out the results.
    
        System.out.println("#####  CALENDAR END  #####");
    }
}
