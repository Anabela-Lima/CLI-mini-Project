import java.util.ArrayList;
import java.util.UUID;


public class Database {

//----------------------UML segment 1: properties -----------------------------------------------------------------

    private Destination destination;
    private UUID id;
    private ArrayList<Passenger> passengerArrayList;
    private ArrayList<Flight>flightArrayList;



//----------------------UML segment 3.1 : constructor  -------------------------------------------------------------

    public Database(Destination destination, UUID id, ArrayList<Passenger> passengerArrayList, ArrayList<Flight> flightArrayList) {
        this.destination = destination;
        this.id = id;
        this.passengerArrayList = passengerArrayList;
        this.flightArrayList = flightArrayList;
    }


//----------------------UML segment 3.2 : getters and setters --------------------------------------------------------

    public Enum getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public ArrayList<Passenger> getPassengerArrayList() {
        return passengerArrayList;
    }

    public void setPassengerArrayList(ArrayList<Passenger> passengerArrayList) {
        this.passengerArrayList = passengerArrayList;
    }

    public ArrayList<Flight> getFlightArrayList() {
        return flightArrayList;
    }

    public void setFlightArrayList(ArrayList<Flight> flightArrayList) {
        this.flightArrayList = flightArrayList;
    }


//----------------------UML segment 3.3 : to string method--------------------------------------------------------------


    @Override
    public String toString() {
        return "Database{" +
                "destination=" + destination +
                ", id=" + id +
                ", passengerArrayList=" + passengerArrayList +
                ", flightArrayList=" + flightArrayList +
                '}';
    }


//-------------------------------------ClientCode----------------------------------------------------------------------

//
////------------------------------------[ Creating  predefined flights for Arraylist ] ----------------------------------

    Flight flight1 = new Flight(Destination.BALI, UUID.randomUUID(), passengerArrayList);
    Flight flight2 = new Flight(Destination.MOROCCO, UUID.randomUUID(), passengerArrayList);
    Flight flight3 = new Flight(Destination.SYDNEY, UUID.randomUUID(), passengerArrayList);
    Flight flight4 = new Flight(Destination.SAOTOME, UUID.randomUUID(), passengerArrayList);
    Flight flight5 = new Flight(Destination.DUBAI, UUID.randomUUID(), passengerArrayList);
    Flight flight6 = new Flight(Destination.NEWYORK, UUID.randomUUID(), passengerArrayList);
    Flight flight7 = new Flight(Destination.ITALY, UUID.randomUUID(), passengerArrayList);
    Flight flight8 = new Flight(Destination.MALDIVES, UUID.randomUUID(), passengerArrayList);
    Flight flight9 = new Flight(Destination.BORABORA, UUID.randomUUID(), passengerArrayList);
    Flight flight10 = new Flight(Destination.HAWAII, UUID.randomUUID(), passengerArrayList);
    Flight flight11 = new Flight(Destination.FIJI, UUID.randomUUID(), passengerArrayList);
    Flight flight12 = new Flight(Destination.COSTARICA, UUID.randomUUID(), passengerArrayList);
    Flight flight13 = new Flight(Destination.FIJI, UUID.randomUUID(), passengerArrayList);



////------------------------------------[ Method to add Passengers to arraylist] -----------------------------------------
//
//
//    public void addPassenger(Passenger passenger) {
//        this.passengerArrayList.add(passenger);
//
//        System.out.println(passenger.getName() + "has been added to SunnySide's passenger list");
//    }
//
////------------------------------------[ Method to get passengerArrayList ] ---------------------------------------------
//
//
//    public ArrayList<Passenger> gePassengerArrayList() {
//        return passengerArrayList;
//    }

//------------------------------------[ Creating predefined Passengers for Arraylist ] ---------------------------------


    public static void main(String[] args) {
        ArrayList<Passenger> passengerArrayList = new ArrayList<>();


        // Creating a list of Passengers to add to:  passengerArrayList- to start with, then the new passenger can
        // be added

        Passenger passenger1 = new Passenger("Ana", UUID.randomUUID(), "Ana@SunnysideFlights.com");
        Passenger passenger2 = new Passenger("Hamza", UUID.randomUUID(), "Hamza@sideFlights.com");
        Passenger passenger3 = new Passenger("Jenna", UUID.randomUUID(), "Jenna@sideFlights.com");
        Passenger passenger4 = new Passenger("Keiran", UUID.randomUUID(), "Keiran@sideFlights.com");


//        System.out.println(passengerArrayList.size());

//-------------------------------------------- Testing ----------------------------------------------------------------


        Flight flight1 = new Flight(Destination.BALI, UUID.randomUUID(), passengerArrayList);
        Flight flight2 = new Flight(Destination.MOROCCO, UUID.randomUUID(), passengerArrayList);
        Flight flight3 = new Flight(Destination.SYDNEY, UUID.randomUUID(), passengerArrayList);
        Flight flight4 = new Flight(Destination.SAOTOME, UUID.randomUUID(), passengerArrayList);
        Flight flight5 = new Flight(Destination.DUBAI, UUID.randomUUID(), passengerArrayList);
        Flight flight6 = new Flight(Destination.NEWYORK, UUID.randomUUID(), passengerArrayList);
        Flight flight7 = new Flight(Destination.ITALY, UUID.randomUUID(), passengerArrayList);
        Flight flight8 = new Flight(Destination.MALDIVES, UUID.randomUUID(), passengerArrayList);
        Flight flight9 = new Flight(Destination.BORABORA, UUID.randomUUID(), passengerArrayList);
        Flight flight10 = new Flight(Destination.HAWAII, UUID.randomUUID(), passengerArrayList);
        Flight flight11 = new Flight(Destination.FIJI, UUID.randomUUID(), passengerArrayList);
        Flight flight12 = new Flight(Destination.COSTARICA, UUID.randomUUID(), passengerArrayList);
        Flight flight13 = new Flight(Destination.FIJI, UUID.randomUUID(), passengerArrayList);


//
//       // passenger books flight:
//
////        System.out.println(passengerArrayList.size());
//        passenger1.bookFlight(flight1, passenger1);
////        System.out.println("Number of passengers after flight is booked:" + passengerArrayList.size());
////

        // passenger cancels flight:

//        passenger1.cancelFlight(passenger1, flight1);

        // checking to see if passenger was able to cancel their flight

//        System.out.println("After flight cancellation:" + passengerArrayList);

//        if ((!passengerArrayList.contains(passenger1)))
//        {System.out.println("yes");}


        Passenger passenger = new Passenger("test", UUID.randomUUID(),"Testpassenger@sunnyside.com");

     passenger.bookFlight(flight8,passenger);
     passenger.cancelFlight(flight8, passenger);








    }














}


