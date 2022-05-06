import java.util.ArrayList;
import java.util.List;

public class Database {

//----------------------UML segment 1: properties -----------------------------------------------------------------
    private ArrayList<Passenger> passengerArrayList;
    private ArrayList<Flight>flightArrayList;

//----------------------UML segment 3.1 : constructor  -------------------------------------------------------------
    public Database() {
        this.passengerArrayList = new ArrayList<>();
        this.flightArrayList = new ArrayList<>();
    }

//----------------------UML segment 3.2 : getters and setters --------------------------------------------------------

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
                "passengerArrayList=" + passengerArrayList +
                ", flightArrayList=" + flightArrayList +
                '}';
    }


//------------------------------------[ Method to add Passengers to arraylist] -----------------------------------------

    public void addPassenger(Passenger passenger) {
        this.passengerArrayList.add(passenger);
        System.out.println(passenger.getName() + " has been added to SunnySide's passenger list");
    }


//------------------------------------[ Method to add flights to arraylist] -----------------------------------------

    public void addFlights(Flight flight) {
        this.flightArrayList.add(flight);
        System.out.println(flight+ " has been added to SunnySide's flight list");
    }
//------------------------------------[ Method to Display Flights] --------------------------------------------------


    public void displayFlights(){
        for (Flight flight : flightArrayList) {
            System.out.println(flight);
        }
    }

    public void displayPassengers(){
        for (Passenger passenger : passengerArrayList) {
            System.out.println(passenger);
        }
    }

    //------static methods for main


    public static boolean doesPassengerExist(Database database, int passengerId) {
        List<Integer> ids = database.getPassengerArrayList()
                .stream()
                .map(Passenger::getID)
                .toList();
        int indexOfPassenger = ids.indexOf(passengerId);
        return indexOfPassenger != -1;
    }

    public static boolean doesFlightExist(Database database, int flightId) {
        List<Integer> ids = database.getFlightArrayList()
                .stream()
                .map(Flight::getId)
                .toList();
        int indexOfPassenger = ids.indexOf(flightId);
        return indexOfPassenger != -1;
    }

    public static boolean doesFlightExist(Database database, Flight flight) {
        return database.getFlightArrayList().contains(flight);
    }

    public static Passenger findPassengerById(Database database, int ID) {
        List<Integer> ids = database.getPassengerArrayList()
                .stream()
                .map(Passenger::getID)
                .toList();
        int indexOfPassenger = ids.indexOf(ID);
        return database.getPassengerArrayList().get(indexOfPassenger);

    }

    public static Flight findFlightById(Database database, int ID) {
        List<Integer> ids = database.getFlightArrayList()
                .stream()
                .map(Flight::getId)
                .toList();
        int indexOfFlight = ids.indexOf(ID);
        return database.getFlightArrayList().get(indexOfFlight);

    }



    // search functionality

    public static List<Flight> SearchFunction(Database database, Destination destination){
        return database.getFlightArrayList()
                .stream()
                .filter(f -> destination.equals(f.getDestination()))
                .toList();
    }


}








