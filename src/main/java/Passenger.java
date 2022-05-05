import java.util.ArrayList;

public class Passenger {


//----------------------UML segment 1: properties --------------------------------------------------------------------


    private String name;
    private int ID;
    private String email;
    private Flight flight;

//----------------------UML segment 3.1 : constructor  ----------------------------------------------------------------

    public Passenger(String name, String email) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        i++;
    }


//----------------------UML segment 3.2 : getters and setters ---------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
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


    public void bookFlight(Flight flight, Passenger passenger) {

        try {
            flight.getPassengerList().add(passenger);

            System.out.println("The number of passengers on this flight is: " + flight.getPassengerList().size());
            System.out.println(this.name + ", your flight to " + flight.getDestination() + " has been booked.");
            System.out.println("Enjoy your holiday \uD83C\uDFD6️ !");
        }
        catch (Exception e) {
            System.out.println("This passenger does not exist😔");
        }
    }


//----------------------UML segment 3.4  Cancel Flight -----------------------------------------------------------------

    public void cancelFlight(Flight flight, Passenger passenger) {
        if (flight.getPassengerList().contains(passenger)) {
            flight.getPassengerList().remove(passenger);
            System.out.println(passenger.name + ", your flight to " + flight.getDestination() + " has been Cancelled.");
            System.out.println("We are sorry to see you go \uD83D\uDE22...");

        } else System.out.println(passenger.getName() + ", we cannot find you on Sunnysideflight's System." +
                " Please book a flight before cancelling.");
    }


//----------------------------------------------------------------------------------------------------------------




}
