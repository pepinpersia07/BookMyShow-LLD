import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookMyShow {
    private int showCounter;
    private ArrayList<User> users;
    private ArrayList<Theatre> theatres;

    public BookMyShow(ArrayList<User> users, ArrayList<Theatre> theatres) {
        this.users = new ArrayList<>();
        this.theatres = new ArrayList<>();
        this.showCounter = 1;
    }

    public BookMyShow() {
        this.users = new ArrayList<>();
        this.theatres = new ArrayList<>();

    }

    // This function adds a new user to our system
    public void addUser(User user) {
        users.add(user);
    }

    // This function adds a new theatre to our system
    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    // Method to register a user and return the registered user
    public RegisteredUser registerUser(GuestUser guestUser) {
        // Check if the user is not already registered
        if (!users.contains(guestUser)) {
            RegisteredUser registeredUser = new RegisteredUser(guestUser.getUserId(), guestUser.getName(), new ArrayList<>());
            users.add(registeredUser);

            System.out.println("User " + guestUser.getName() + " successfully registered!");

            return registeredUser; // Return the registered user
        } else {
            System.out.println("Error: User is already registered!");
            return null; // Return null if registration fails
        }
    }

    // Method to display all users (for testing purposes)
    public void displayUsers() {
        System.out.println("List of Users:");
        for (User user : users) {
            System.out.println("User ID: " + user.getUserId() + ", Name: " + user.getName());
        }
    }

    //displaying shows
    public void displayShows() {
        for (Theatre theatre : theatres) {
            System.out.println("Shows at " + theatre.getName() + ":");
            for (Show show : theatre.getShows()) {
                System.out.println("Show ID: " + show.getId() +
                        ", Movie: " + show.getMovie().getName() +
                        ", Time: " + show.getShowTime() +
                        ", Available Seats: " + show.getAvailableSeats());
            }
            System.out.println();  // Just to make it look nice
        }
    }


    // This function books a ticket for a registered user
    public Ticket bookTicket(RegisteredUser user, Show show, int noOfSeats) {
        if (user != null && show != null && user instanceof RegisteredUser) {
            if (show.getAvailableSeats() >= noOfSeats) {
                // Reduce available seats
                show.setAvailableSeats(show.getAvailableSeats() - noOfSeats);

                // Create a new ticket
                Ticket ticket = new Ticket(user.getUserId(), user.getName(), new Date(), noOfSeats, show);

                // Add the ticket to the user's booking history
                user.getBookingHistory().add(ticket);
                System.out.println("Ticket booked successfully");

                return ticket;
            } else {
                System.out.println("Not enough available seats for the selected show.");
                return null;
            }
        } else {
            System.out.println("Invalid user or show provided.");
            return null;
        }
    }

    // Method to add a show to a theatre
    public void addShowToTheatre(Theatre theatre, Show show) {

        // Add the show to the theatre's list of shows
        theatre.getShows().add(show);

        System.out.println("Show added successfully to " + theatre.getName() + ".");
    }

    // Method to search for shows based on criteria
    public ArrayList<Show> searchShows(String searchTerm) {
        ArrayList<Show> searchResults = new ArrayList<>();

        for (Theatre theatre : theatres) {
            for (Show show : theatre.getShows()) {
                // Perform a simple search based on the show name or any other criteria
                if (show.getMovie().getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                    searchResults.add(show);
                }
            }
        }

        return searchResults;
    }

    // Method to search for shows based on user input
    public void searchShowsByUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the search term:");
        String searchTerm = scanner.nextLine();

        ArrayList<Show> searchResults = searchShows(searchTerm);

        // Displaying the search results
        for (Show show : searchResults) {
            System.out.println("Show ID: " + show.getId() +
                    ", Movie: " + show.getMovie().getName() +
                    ", Time: " + show.getShowTime() +
                    ", Available Seats: " + show.getAvailableSeats());
        }
    }

}
