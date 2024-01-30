import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        GuestUser guestUser = new GuestUser(1, "Pepin");
        RegisteredUser rU1 = bookMyShow.registerUser(guestUser);
        bookMyShow.displayUsers();
        Theatre theatre1 = new Theatre(1,"kamala","chennai",50);
        bookMyShow.addTheatre(theatre1);
        Movie movie1 = new Movie("Barbie",Language.ENGLISH,Genre.COMEDY);
        Show show1 = new Show(1,new Date(2024-02-05),movie1,theatre1);
        bookMyShow.addShowToTheatre(theatre1,show1);
        bookMyShow.displayShows();
        Movie movie2 = new Movie("Harry Potter",Language.ENGLISH,Genre.ACTION);
        Show show2 = new Show(2,new Date(2024-02-01),movie2,theatre1);
        bookMyShow.addShowToTheatre(theatre1,show2);
        bookMyShow.displayShows();
        bookMyShow.bookTicket(rU1,show2,2);
        bookMyShow.displayShows();
        }
}