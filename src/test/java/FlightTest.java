import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.util.Collections;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;


public class FlightTest {

    Database informationStored;
    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;

    Flight flight1;
    Flight flight2;
    Flight flight3;
    Flight flight4;
    Flight flight5;
    Flight flight6;
    Flight flight7;
    Flight flight8;
    Flight flight9;
    Flight flight10;
    Flight flight11;
    Flight flight12;
    Flight flight13;


    @BeforeEach
    void addFlightsAndPassengers() {

        informationStored = new Database();

        passenger1 = new Passenger("Ana", "Ana@SunnysideFlights.com");
        passenger2 = new Passenger("Hamza", "Hamza@sideFlights.com");
        passenger3 = new Passenger("Jenna", "Jenna@sideFlights.com");
        passenger4 = new Passenger("Kieran", "Kieran@sideFlights.com");

        Collections.addAll(informationStored.getPassengerArrayList(), passenger1, passenger2, passenger3, passenger4);


        flight1 = new Flight(Destination.BALI);
        flight2 = new Flight(Destination.MOROCCO);
        flight3 = new Flight(Destination.SYDNEY);
        flight4 = new Flight(Destination.SAOTOME);
        flight5 = new Flight(Destination.DUBAI);
        flight6 = new Flight(Destination.NEWYORK);
        flight7 = new Flight(Destination.ITALY);
        flight8 = new Flight(Destination.MALDIVES);
        flight9 = new Flight(Destination.BORABORA);
        flight10 = new Flight(Destination.HAWAII);
        flight11 = new Flight(Destination.FIJI);
        flight12 = new Flight(Destination.COSTARICA);
        flight13 = new Flight(Destination.SEYCHELLES);

        Collections.addAll(informationStored.getFlightArrayList(), flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8,
                flight9, flight10, flight11, flight12, flight13);

    }

    @Test
    void startsWith13Flights() {
        assertEquals(13, informationStored.getFlightArrayList().size());
    }

    @Test
    void newFlightAdded() {
        Flight flight14 = new Flight(Destination.MOROCCO);
        Collections.addAll(informationStored.getFlightArrayList(), flight14);
        assertEquals(14, informationStored.getFlightArrayList().size());
    }

    @Test
    void startsWith4Passengers() {
        assertEquals(4, informationStored.getPassengerArrayList().size());
    }

    @Test
    void newPassengerAdded() {
        Passenger passenger5 = new Passenger("Colin", "Colin@sideFlights.com");
        Collections.addAll(informationStored.getPassengerArrayList(), passenger5);
        assertEquals(5, informationStored.getPassengerArrayList().size());
    }

    @Test
    void noPassengersOnFlight() {
        assertEquals(4, informationStored.getPassengerArrayList().size());
    }

    @Test
    void passengerAddedToFlight() {
        // using passenger 2
        passenger2.bookFlight(flight8, passenger2);
        assertTrue(flight8.getPassengerList().contains(passenger2));
    }

    @Test
    void cancelFlight() {

        // using passenger 1
        passenger1.cancelFlight(flight2, passenger1);

        assertFalse(flight2.getPassengerList().contains(passenger1));
    }

    @Test
    void passengerHasNameContactAndID() {

        // using passenger 2
        assertEquals(passenger2.getName(), "Hamza");
        assertEquals(passenger2.getEmail(), "Hamza@sideFlights.com");
    }

    @Test
    void flightHasDestinationIDAndPassengers() {
        assertEquals(flight2.getDestination(), "MOROCCO");
        assertEquals(5, informationStored.getPassengerArrayList().size());
    }


}