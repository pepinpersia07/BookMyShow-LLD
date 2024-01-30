import java.util.ArrayList;

public class RegisteredUser extends User{
    private ArrayList<Ticket> bookingHistory;

    public RegisteredUser(int userId, String name, ArrayList<Ticket> bookingHistory) {
        super(userId, name);
        this.bookingHistory = new ArrayList<>();
    }

    public RegisteredUser(int userId, String name) {
        super(userId,name);
    }

    // Additional method to get the booking history
    public ArrayList<Ticket> getBookingHistory() {
        return bookingHistory;
    }

    // Method to cancel a booked ticket
    public void cancelTicket(Ticket ticket) {
        if (ticket != null) {
            // Remove the ticket from booking history
            bookingHistory.remove(ticket);

            // Add the seats back to the available seats for the show
            Show bookedShow = ticket.getBookedShow();
            bookedShow.setAvailableSeats(bookedShow.getAvailableSeats() + ticket.getNoOfSeats());

            System.out.println("Ticket canceled successfully.");
        } else {
            System.out.println("Invalid ticket provided.");
        }
    }
}
