package movieticketsystem;

import java.io.Serializable;

public class Ticket implements Serializable {

    private String CostumerName;
    private String MovieName;
    private String Time;
    private int SeatNumber;
    private char Venue;
    private String Category;

    public Ticket() {
    }

    public Ticket(String CostumerName, String MovieName, String Time, int SeatNumber, char Venue, String Category) {
        this.CostumerName = CostumerName;
        this.MovieName = MovieName;
        this.Time = Time;
        this.SeatNumber = SeatNumber;
        this.Venue = Venue;
        this.Category = Category;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public int getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(int SeatNumber) {
        this.SeatNumber = SeatNumber;
    }

    public char getVenue() {
        return Venue;
    }

    public void setVenue(char Venue) {
        this.Venue = Venue;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getCostumerName() {
        return CostumerName;
    }

    public void setCostumerName(String CostumerName) {
        this.CostumerName = CostumerName;
    }

    public int getTicketPrice(String CategoryName) {
        if (CategoryName.equals("silver")) {
            return 100;
        } else if (CategoryName.equals("gold")) {
            return 150;
        } else {
            return 200;
        }
    }

}
