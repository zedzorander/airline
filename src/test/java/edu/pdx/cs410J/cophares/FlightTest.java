package edu.pdx.cs410J.cophares;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit tests for the {@link Flight} class.
 *
 */
public class FlightTest {

    private String arriveTime = "09/28/2017 07:34";
    private String departTime = "09/28/2017 05:34";
    private int number = 42;
    private String pdx = "PDX";
    private String lax = "LAX";
    private Flight flight;

    @Before
    public void setUp() throws Exception {
        flight = new Flight(number, pdx, departTime, lax, arriveTime);
    }

    @Test
    public void getNumber(){
        assertThat(flight.getNumber(), equalTo(number));
    }

    @Test
    public void sourceNamedPDXIsNamedPDX(){
        assertThat(flight.getSource(), equalTo(pdx));
    }

    @Test
    public void destinationNamedLAXIsNamedLAX(){
        assertThat(flight.getDestination(), equalTo(lax));
    }

    @Test
    public void getArrivalString(){
        assertThat(flight.getArrivalString(), equalTo(arriveTime));
    }

    @Test
    public void getDepartureString(){
        assertThat(flight.getDepartureString(), equalTo(departTime));
    }

    @Test
    public void initiallyAllFlightsHaveTheSameNumber() {
        assertThat(flight.getNumber(), equalTo(number));
    }

    @Test
    public void forProject1ItIsOkayIfGetDepartureTimeReturnsNull() {
        assertThat(flight.getDeparture(), is(nullValue()));
    }
  
}
