import javax.xml.crypto.Data;
import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Database informationStored = new Database();

        Passenger passenger1 = new Passenger("Ana", "Ana@SunnysideFlights.com");
        Passenger passenger2 = new Passenger("Hamza", "Hamza@sideFlights.com");
        Passenger passenger3 = new Passenger("Jenna", "Jenna@sideFlights.com");
        Passenger passenger4 = new Passenger("Kieran", "Kieran@sideFlights.com");

        Collections.addAll(informationStored.getPassengerArrayList(), passenger1, passenger2, passenger3,passenger4);


        Flight flight1 = new Flight(Destination.BALI);
        Flight flight2 = new Flight(Destination.MOROCCO);
        Flight flight3 = new Flight(Destination.SYDNEY);
        Flight flight4 = new Flight(Destination.SAOTOME);
        Flight flight5 = new Flight(Destination.DUBAI);
        Flight flight6 = new Flight(Destination.NEWYORK);
        Flight flight7 = new Flight(Destination.ITALY);
        Flight flight8 = new Flight(Destination.MALDIVES);
        Flight flight9 = new Flight(Destination.BORABORA);
        Flight flight10 = new Flight(Destination.HAWAII);
        Flight flight11 = new Flight(Destination.FIJI);
        Flight flight12 = new Flight(Destination.COSTARICA);
        Flight flight13 = new Flight(Destination.SEYCHELLES);
        Flight flight14 = new Flight(Destination.SAOTOME);

        Collections.addAll(informationStored.getFlightArrayList(), flight1, flight2, flight3, flight4, flight5, flight6, flight7, flight8,
                flight9, flight10, flight11, flight12, flight13, flight14);

        String Options = "Welcome to our Flight Manager! Type \n f to create a new flight, \n d to display all current flights,";
        Options += " \n p to add a new passenger, \n b to book a passenger onto a flight, \n c to cancel a flight, ";
        Options += "\n s to search for flights to a certain destination, ";
        Options += "\n and q to quit!";
        System.out.println(Options);

        boolean loop = true;
        boolean insideLoops = false;

        Scanner scanner = new Scanner(System.in);

        List<String> toAddToFile = new ArrayList<>();

        while(loop) {
            System.out.println("\nType your command. Type o to again see the possible options.");
            String command = scanner.next();
            switch (command) {
                case "o" :
                    System.out.println(Options);

                case "f":
                    System.out.println("We will need a destination to make a new flight! Where is it heading to?");
                    String destination = scanner.next();

                    insideLoops = Destination.CheckDestination(destination);

                    while (!insideLoops) {
                        System.out.println("Not a valid location! What is the destination?");
                        destination = scanner.next();
                        insideLoops = Destination.CheckDestination(destination);

                    }

                    informationStored.addFlights(new Flight(Destination.valueOf(destination.toUpperCase())));
                    break;

                case "d" :
                    informationStored.displayFlights();
                    break;

                case "p":
                    System.out.println("What is the name of this Passenger? ");
                    String name = scanner.next();
                    insideLoops = name.matches("[a-zA-Z]+");

                    // check name is valid
                    while (!insideLoops) {
                        System.out.println("Not a valid name! What is the name of the Passenger?");
                        name = scanner.next();
                        insideLoops = name.matches("[a-zA-Z]+");
                    }

                    System.out.println("What is the Passenger's email? ");
                    String email = scanner.next();
                    insideLoops = Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches();

                    // check email is valid
                    while (!insideLoops) {
                        System.out.println("Not a valid email! What is the Passenger's email?");
                        email = scanner.next();
                        insideLoops = Pattern.compile("^(.+)@(\\S+)$").matcher(email).matches();
                    }

                    informationStored.addPassenger(new Passenger(name, email));
                    break;

                case "b":
                    int passengerID = 0;
                    System.out.println("What is the unique ID of the Passenger booking? ");

                    boolean anInt = false;

                    while (!anInt) {
                        try {
                            passengerID = scanner.nextInt();
                            anInt = true;
                        } catch (Exception e) {
                            System.out.println("That is not a valid ID! What is the actual ID? ");
                            scanner.next();
                        }
                    }


                    boolean PassengerExists = Database.doesPassengerExist(informationStored, passengerID);

                    while (!PassengerExists) {
                        System.out.println("That passenger doesn't exist! What is the unique ID of the Passenger booking? ");

                        anInt = false;

                        while (!anInt) {
                            try {
                                passengerID = scanner.nextInt();
                                anInt = true;
                            } catch (Exception e) {
                                System.out.println("That is not a valid ID! What is the actual ID? ");
                                scanner.next();
                            }
                        }

                        PassengerExists = Database.doesPassengerExist(informationStored, passengerID);
                    }

                    Passenger bookingPassenger = Database.findPassengerById(informationStored, passengerID);

                    System.out.println("What is the unique ID of the Flight the Passenger wishes to book? ");

                    int flightID = scanner.nextInt();

                    anInt = false;



                    boolean FlightExists = Database.doesFlightExist(informationStored, flightID);

                    while (!FlightExists) {
                        System.out.println("This flight doesn't exist! What is the unique ID of the flight?");
                        flightID = scanner.nextInt();
                        FlightExists = Database.doesFlightExist(informationStored, flightID);
                    }


                    Flight bookingFlight = Database.findFlightById(informationStored, flightID);
                    bookingPassenger.bookFlight(bookingFlight, bookingPassenger);

                    toAddToFile.add(bookingPassenger + " has booked to go on " + bookingFlight + "\n\n");


                    break;
                case "c":
                    System.out.println("What is the unique ID of the Passenger cancelling? ");
                    int cancelPassengerID = scanner.nextInt();

                    PassengerExists =Database.doesPassengerExist(informationStored, cancelPassengerID);

                    while (!PassengerExists) {
                        System.out.println("That passenger doesn't exist! What is the unique ID of the Passenger cancelling? ");
                        cancelPassengerID = scanner.nextInt();
                        PassengerExists = Database.doesPassengerExist(informationStored, cancelPassengerID);
                    }
                    Passenger cancellingPassenger = Database.findPassengerById(informationStored, cancelPassengerID);

                    System.out.println("What is the unique ID of the flight you'd like to cancel?");
                    int cancelFlightID = scanner.nextInt();

                    FlightExists = Database.doesFlightExist(informationStored, cancelFlightID);

                    while (!FlightExists) {
                        System.out.println("That flight doesn't exist! What is the accurate flight ID? ");
                        cancelFlightID = scanner.nextInt();
                        FlightExists = Database.doesFlightExist(informationStored, cancelFlightID);
                    }

                    Flight cancelFlight = Database.findFlightById(informationStored, cancelFlightID);
                    cancellingPassenger.cancelFlight(cancelFlight, cancellingPassenger);
                    break;

                case "s" :
                    System.out.println("What destination do you want to search for? ");
                    String searchDestination = scanner.next();

                    insideLoops = Destination.CheckDestination(searchDestination);

                    while (!insideLoops) {
                        System.out.println("Not a valid location! What is the destination?");
                        searchDestination = scanner.next();
                        insideLoops = Destination.CheckDestination(searchDestination);
                    }

                    System.out.println(Database.SearchFunction(informationStored, Destination.valueOf(searchDestination.toUpperCase())));

                    break;

                case "q" :
                    loop = false;
                    break;

                default:
                    System.out.println("We didn't seem to recognise your command!");
            }

        }

        try {
            FileWriter myWriter = new FileWriter("Passenger_List.txt");
            for (String element : toAddToFile) {
                myWriter.write(element);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
