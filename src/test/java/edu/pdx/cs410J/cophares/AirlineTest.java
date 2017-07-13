package edu.pdx.cs410J.cophares;

import edu.pdx.cs410J.AbstractFlight;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Cole on 7/8/2017.
 */
public class AirlineTest {

    private Airline airline;
    private String delta = "Delta";
    private AbstractFlight abstractFlight;

    @Test
    public void addNameNeedsToBeImplemented(){
        airline = new Airline(delta);
        assertThat(airline.getName(), equalTo(delta));
    }

    @Test
    public void addOneFlightToAirline() {
        createAirlineAndAddOneFlight();
        assertThat(airline.toString(), containsString(delta + " with " + 1 + " flights"));
    }

    @Test
    public void addTwoFlightsToAirline() {
        createAirlineAndAddTwoFlights();
        assertThat(airline.toString(), containsString(delta + " with " + 2 + " flights"));
    }

    @Test
    public void getOneFlightFromAirline(){
        createAirlineAndAddOneFlight();
        assertThat(airline.toString(), containsString(delta + " with " + airline.getFlights().size() + " flights"));
    }

    public void createAirlineAndAddOneFlight() {
        airline = new Airline(delta);
        abstractFlight = new Flight(42, "PDX",  "09/28/2017 05:34", "LAX", "09/28/2017 07:34");
        airline.addFlight(abstractFlight);
    }

    @Test
    public void getTwoFlightsFromAirline(){
        createAirlineAndAddTwoFlights();
        assertThat(airline.toString(), containsString(delta + " with " + airline.getFlights().size() + " flights"));
    }

    public void createAirlineAndAddTwoFlights() {
        createAirlineAndAddOneFlight();
        abstractFlight = new Flight(43, "SFO", "09/28/2017 05:34", "KCI", "09/28/2017 07:34");
        airline.addFlight(abstractFlight);
    }
}
