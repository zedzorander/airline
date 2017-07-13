package edu.pdx.cs410J.cophares;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AbstractFlight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The main class for the CS410J airline Project
 * Author:          Cole Phares
 * Last Modified:   7/12/2017
 * Description:     Main class for Project1. Parses command line arguments and creates a flight from given data.
 */
public class Project1 {

    public static void main(String[] args) {
        Class c = AbstractAirline.class;  // Refer to one of Dave's classes so that we can be sure it is on the classpath
        Airline airline;

        if(args.length < 6) {
            System.err.println("Missing command line arguments");
            System.exit(1);
        }

        int index = 0;
        String optionOne = null;
        String optionTwo = null;
        //check for and assigns any -print and -README options in command line
        if(args[index].startsWith("-") && args[index + 1].startsWith("-")){
            optionOne = args[index++];
            optionTwo = args[index++];
        }else if(args[index].startsWith("-"))
            optionOne = args[index++];

        String name = args[index++];
        airline = new Airline(name);
        int flightNumber = parseFlightNumber(args[index++]);
        //gets departing airport code from command line and checks for valid length
        String src = args[index++];
        if(src.length() != 3){
            System.err.println("Invalid Source Airport Code: " + src);
            System.exit(1);
        }
        //gets depart time from command line and checks for valid command line date input
        String departTime = args[index++];
        String datePattern = "(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/((20)\\d\\d) ([01]?[0-9]|2[0-3]):[0-5][0-9]";
        if(!dateValidation(departTime, datePattern)){
            System.err.println("Invalid Depart Time: " + departTime);
            System.exit(1);
        }
        //gets arriving airport code from command line and checks for valid length
        String dest = args[index++];
        if(dest.length() != 3){
            System.err.println("Invalid Destination Airport Code: " + dest);
            System.exit(1);
        }
        //gets arrive time from command line and checks for valid command line date input
        String arriveTime = args[index++];
        if(!dateValidation(arriveTime, datePattern)){
            System.err.println("Invalid Arrive Time: " + arriveTime);
            System.exit(1);
        }

        //create flight and check for -print and -README options
        Flight flight = new Flight(flightNumber, src, departTime, dest, arriveTime);
        if(optionOne != null && optionTwo != null){
            //if both are spelled correctly, print out flight details, readme file, and exit
            if(optionOne.equalsIgnoreCase("-print") && optionTwo.equalsIgnoreCase("-README")
                    || optionOne.equalsIgnoreCase("-README") && optionTwo.equalsIgnoreCase("-print")){
                System.out.println(flight.toString());
                printReadMe();
                airline.printReadMe();
                flight.printReadMe();
                System.exit(-1);
            //print error message and exit if one of the options is misspelled
            }else{
                System.err.println("Invalid option given: " + optionOne + " or " + optionTwo);
                System.exit(1);
            }
        }else if(optionOne != null){
            //if only option is -print, print flight details
            if(optionOne.equalsIgnoreCase("-print"))
                System.out.println(flight.toString());
            //if only option is -README, print readme file and exit
            else if(optionOne.equalsIgnoreCase("-README")){
                printReadMe();
                airline.printReadMe();
                flight.printReadMe();
                System.exit(-1);
            }else {
                System.err.println("Invalid Flight Number!");
                System.exit(1);
            }
        }
        //create arline and add flight to airline
        airline.addFlight(flight);
        System.out.println(airline.toString() + "\n" + flight.toString());

        System.exit(0);
    }

    /**
     * turns flight number string command line argument into int
     * @param flightNumber flights identifying number
     * @return true if parameter can be converted to int, otherwise exits with error 1
     */
    private static int parseFlightNumber(String flightNumber) {
        try {
            return Integer.parseInt(flightNumber);
        }catch(NumberFormatException ex){
            System.err.println("Invalid Flight Number!");
            System.exit(1);
            return -1;
        }
    }

    //following code taken from http://www.mkyong.com/regular-expressions/how-to-validate-date-with-regular-expression/
    /**
     * Validate date format with regular expression
     * @param flightTime date address for validation
     * @param datePattern regular expression format
     * @return true valid date format, false invalid date format
     */
    private static boolean dateValidation(String flightTime, String datePattern){
        Pattern pattern = Pattern.compile(datePattern);
        Matcher matcher;


        matcher = pattern.matcher(flightTime);

        if(matcher.matches()){

            matcher.reset();

            if(matcher.find()) {

                String day = matcher.group(1);
                String month = matcher.group(2);
                int year = Integer.parseInt(matcher.group(3));

                if (day.equals("31") && (month.equals("4") || month.equals("6") || month.equals("9") ||
                        month.equals("11") || month.equals("04") || month.equals("06") || month.equals("09"))) {
                    return false; // only 1,3,5,7,8,10,12 has 31 days
                } else if (month.equals("2") || month.equals("02")) {
                    //leap year
                    if (year % 4 == 0) {
                        if (day.equals("30") || day.equals("31")) {
                            System.err.println("Invalid Date!");
                            return false;
                        } else
                            return true;
                    } else
                        return !(day.equals("29") || day.equals("30") || day.equals("31"));
                }else
                    return true;
            }else
                return false;
        }else
            return false;
    }

    private static void printReadMe(){
        System.out.println("Contains the test classes for the CS410J Airline project.\n\n" +
                            "Class Project1\n\n" + "public class Project1\n" +
                            "This class runs the program and parses the strings in args.\n\n" +
                            "Method Detail\n" + "parseFlightNumber\n" +
                            "private static int parseFlightNumber(String flightNumber)\n" +
                            "Parses flightNumber into an int. Exits with code 1 if not able to be converted.\n\n" +
                            "dateValidation(String flightTime, String datePattern)\n" +
                            "private static boolean dateValidation(String flightTime, String datePattern)\n" +
                            "Validate date format with regular expression.\n");
    }
}

