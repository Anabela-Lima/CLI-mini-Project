import java.util.ArrayList;

public class Flight {


//----------------------UML segment 1: properties ----------------------------------
    private Destination destination;
    private int ID;
    private ArrayList<Passenger> passengerList;
    public static int i=1000;
//----------------------UML segment 3.1 : constructor  ----------------------------------

    public Flight(Destination destination) {
        this.destination = destination;
        this.passengerList = new ArrayList<>();
        this.ID = i;
        i++;
    }

//----------------------UML segment 3.2 : getters and setters ------------------------------


    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(ArrayList<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public int getId () {
        return ID;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "destination=" + destination +
                ", ID=" + ID +
                '}';
    }


}
