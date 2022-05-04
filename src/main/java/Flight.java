import java.util.ArrayList;
import java.util.UUID;

public class Flight {


//----------------------UML segment 1: properties ----------------------------------


    private Destination destination;
    private UUID id ;
    private ArrayList<Passenger> passengerList= new ArrayList<>();



//----------------------UML segment 3.1 : constructor  ----------------------------------

    public Flight(Destination destination, UUID id, ArrayList<Passenger> passengerList) {
        this.destination = destination;
        this.id = id;
        this.passengerList = passengerList;
    }


//----------------------UML segment 3.2 : getters and setters ------------------------------


    public Destination getDestination() {
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

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList) {
        this.passengerList = passengerList;

    }
}
