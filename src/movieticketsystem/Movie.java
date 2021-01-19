package movieticketsystem;

import java.io.Serializable;

public class Movie implements Serializable {

    private String MovieName;
    private char Venue;

    public Movie() {
    }

    public Movie(String MovieName, char Venue) {
        this.MovieName = MovieName;
        this.Venue = Venue;
    }

    public String getMovieName() {
        return MovieName;
    }

    public void setMovieName(String MovieName) {
        this.MovieName = MovieName;
    }

    public char getVenue() {
        return Venue;
    }

    public void setVenue(char Venue) {
        this.Venue = Venue;
    }

}
