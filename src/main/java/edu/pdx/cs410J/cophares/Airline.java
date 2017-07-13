package edu.pdx.cs410J.cophares;

import edu.pdx.cs410J.AbstractAirline;
import edu.pdx.cs410J.AbstractFlight;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Author:          Cole Phares
 * Last Modified:   7/12/2017
 * Description:     Airline class stores flight information for each airline
 */
public class Airline extends AbstractAirline{

    private String airlineName;
    Collection<AbstractFlight> flights;

    /**
     * Constructor for airline class
     * @param name
     */
    Airline(String name){
        airlineName = name;
        flights = new ArrayList<>();
    }

    /**
     * This method returns the name of the airline of the flight
     * @return airlineName
     */
    @Override
    public String getName() {
        return airlineName;
    }

    /**
     * This function adds a flight to the airlines collection of flights
     * @param abstractFlight
     */
    @Override
    public void addFlight(AbstractFlight abstractFlight) {
        flights.add(abstractFlight);
    }

    /**
     * This function returns the collection of flights for the airline
     * @return flights
     */
    @Override
    public Collection getFlights() {
        return flights;
    }

    public void printReadMe() {
        System.out.println("Class Airline\n\n" + "public class Airline\nextends AbstractAirline\n" +
                "Airline class stores flight information for each airline\n\n" +
                "Constructor Detail\n" + "Airline(String name)\n" +
                "name: name of the airline.\n\n" + "Method Detail\n" + "getName\n" +
                "public int getName()\n" + "Returns airline name.\n" + "Overrides:\ngetName in class AbstractAirline\n\n" +
                "addFlight\n" + "public void addFlight(AbstractFlight abstractFlight)\n" +
                "This function adds a flight to the airlines collection of flights\n" +
                "Overrides:\naddFlight in class AbstractAirline\n\n" + "getFlights\n" +
                "public Collection getFlights()\n" + "Returns a collection of flights\n" +
                "Overrides:\ngetFlights class in AbstractAirline\n");
    }
}
