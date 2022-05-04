import java.util.ArrayList;
import java.util.UUID;

public class Passenger {


//----------------------UML segment 1: properties --------------------------------------------------------------------


    private String name;
    private UUID ID;
    private String email;
    private Flight flight;

//----------------------UML segment 3.1 : constructor  ----------------------------------------------------------------



    public Passenger(String name, UUID ID, String email) {
        this.name = name;
        this.ID = ID;
        this.email = email;
    }

//----------------------UML segment 3.2 : getters and setters ---------------------------------------------------------


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//----------------------UML segment 3.3 : to string method-----------------------------------------------------------



    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", ID=" + ID +
                ", email='" + email + '\'' +
                '}';
    }


//----------------------UML segment 3.4  Book flight  -----------------------------------------------------------------

    public static void main(String[] args) {

    }

    public void  bookFlight(Flight flight, Passenger passenger) {
        this.flight = flight;
        this.flight.getPassengerList().add(passenger);


        ArrayList<Passenger> passengerArrayList = new ArrayList<>();
        this.flight.setPassengerList(passengerArrayList);

        // predefined list of passengers

        Passenger passenger1 = new Passenger("Ana", UUID.randomUUID(), "Ana@SunnysideFlights.com§");
        Passenger passenger2 = new Passenger("Hamza", UUID.randomUUID(), "Hamza@sideFlights.com");
        Passenger passenger3 = new Passenger("Jenna", UUID.randomUUID(), "Jenna@sideFlights.com");
        Passenger passenger4 = new Passenger("Keiran", UUID.randomUUID(), "Keiran@sideFlights.com");

        passengerArrayList.add(passenger1);
        passengerArrayList.add(passenger2);
        passengerArrayList.add(passenger3);
        passengerArrayList.add(passenger4);

        System.out.println("Number of passengers Before flight is booked by passenger:" + passengerArrayList.size());


        // add the new passenger to the array list


        passengerArrayList.add(passenger);

        System.out.println("Number of passengers after flight is booked:" + passengerArrayList.size());

        System.out.println( this.name + ", your flight to " + flight.getDestination()+ " has been booked.");

        System.out.println("Enjoy your holiday \uD83C\uDFD6️ !");


        System.out.println(passengerArrayList);



    }


//----------------------UML segment 3.4  Cancel Flight -----------------------------------------------------------------

    public void  cancelFlight( Flight flight,Passenger passenger) {

        this.flight = flight;


//         remove only if passenger is in passenger list


        if (flight.getPassengerList().contains(passenger))

        {  System.out.println("Number of passengers before flight is cancelled: " + flight.getPassengerList().size());
            this.flight.getPassengerList().remove(passenger);
            System.out.println( passenger.name + ", your flight to " + flight.getDestination() +" has been Cancelled");
            System.out.println("We are sorry to see you go \uD83D\uDE22..." );}

        else System.out.println(passenger.getName()+ ", we cannot find you on Sunnysideflight's System. Please " +
                "book a flight before cancelling");



        System.out.println("Number of passengers after flight is cancelled: " + flight.getPassengerList().size());
        // remove passenger from arraylist








    }


//----------------------------------------------------------------------------------------------------------------




}
