package edu.pdx.cs410J.cophares;
import edu.pdx.cs410J.AbstractFlight;

/**
 * Author:          Cole Phares
 * Last Modified:   7/12/2017
 * Description:     Flight class stores the data for a plane flight.
 */
public class Flight extends AbstractFlight {
    private int flightNumber;
    private String source;
    private String departTime;
    private String destination;
    private String arriveTime;

    /**
     * Constructor for the flight class
     * @param number flight number identifier
     * @param src airport code of departing city
     * @param departTime time flight departs src
     * @param dest airport code of arriving city
     * @param arriveTime time flight arrives at dest
     */
    Flight(int number, String src, String departTime, String dest, String arriveTime){
        flightNumber = number;
        source = src;
        this.departTime = departTime;
        destination = dest;
        this.arriveTime = arriveTime;
    }

    /**
     * This method returns the specified flight number
     * @return flightNumber
     */
    @Override
    public int getNumber() {
        return flightNumber;
    }

    /**
     * This method returns the departing airport code
     * @return source
     */
    @Override
    public String getSource() {
        return source;
    }

    /**
     * This method returns the departure time of the flight
     * @return departTime
     */
    @Override
    public String getDepartureString() {
        return departTime;
    }

    /**
     * This method returns the arriving airport code
     * @return destination
     */
    @Override
    public String getDestination() {
        return destination;
    }

    /**
     * This method returns the arrival time of the flight
     * @return arriveTime
     */
    @Override
    public String getArrivalString() {
        return arriveTime;
    }

    public void printReadMe() {
        System.out.println("Class Flight\n\n" + "public class Flight\nextends AbstractFlight\n" +
                            "Flight class stores the data for a plane flight.\n\n" +
                            "Constructor Detail\n" + "Flight(int number, String src, String departTime, String dest, String arriveTime)\n" +
                            "number: flight number identifier\n" + "src: airport code of departing city\n" +
                            "departTime: time flight departs src\n" + "dest: airport code of arriving city\n" +
                            "arriveTime: time flight arrives at dest\n\n" + "Method Detail\n" + "getNumber\n" +
                            "public int getNumber()\n" + "Returns flight number.\n" + "Overrides:\ngetNumber in class AbstractFlight\n\n" +
                            "getSource\n" + "public String getSource()\n" + "Returns the flights departure city code\n" +
                            "Overrides:\ngetSource in class AbstractFlight\n\n" + "getDepartureString\n" +
                            "public String getDepartureString()\n" + "Returns flights departure time.\n" +
                            "Overrides:\ngetDepartureString class in AbstractFlight\n\n" + "getDestination\n" +
                            "public String getDestination()\n" + "Returns flights arrival city code\n" +
                            "Overrides:\ngetDestination in class AbstractFlight\n\n" + "getArrivalString\n" +
                            "public String getArrivalString()\n" + "Returns flights arrival time.\n" +
                            "Overrides:\ngetArrivalString in class AbstractFlight\n");
    }
}
