package movieticketsystem;

import java.io.*;
import java.util.ArrayList;

public class Manager extends Data {

    private ArrayList<Movie> MovieList = new ArrayList<>();
    private ArrayList<Cashier> CashierList = new ArrayList<>();

    private String CashierFilename = "Cashiers.txt";
    private String MovieFilename = "Movies.txt";
    
    public Manager() {
    }

    public Manager(int ID, String Name, String UserName, String Password) {
        super(ID, Name, UserName, Password);
    }

    @Override
    public String toString() {
        return ("ID: " + getID() + "\nName: " + getName() + "\nUsername: " + getUserName() + "\nPassword: " + getPassword());

    }

    public void AddCashier(Cashier e) {
        CashierList.add(e);
        AddCashierinFile();
    }

    public void AddCashierinFile() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(CashierFilename));
            os.writeObject(CashierList);
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        }
    }

    public void RemoveCashier(int CashierID) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
            ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
            is.close();
            for (Cashier cashier : importedCashierList) {
                if (CashierID == cashier.getID()) {
                    importedCashierList.remove(cashier);
                    break;
                }
            }
            CashierList = importedCashierList;
            AddCashierinFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void UpdateCashier(int CashierID, String NewName) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
            ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
            is.close();
            for (Cashier cashier : importedCashierList) {
                if (CashierID == cashier.getID()) {
                    importedCashierList.remove(cashier);
                    Cashier newCashier = new Cashier(CashierID, NewName);
                    importedCashierList.add(newCashier);
                    break;
                }
            }
            CashierList = importedCashierList;
            AddCashierinFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }

    }

    public void DisplayCashier(Cashier u1) {
        System.out.println("ID: " + u1.getID() + "\nName: " + u1.getName());
        System.out.println("");
    }

    public void DisplayAllCashiers() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
            ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
            is.close();
            for (Cashier cashier : importedCashierList) {
                DisplayCashier(cashier);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void AddMovie(Movie m) {
        MovieList.add(m);
        AddMovieinFile();
    }

    public void AddMovieinFile() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MovieFilename));
            os.writeObject(MovieList);
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        }
    }

    public void RemoveMovie(String MovieName) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
            ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
            is.close();
            for (Movie m : importedMovieList) {
                if (MovieName.equals(m.getMovieName())) {
                    importedMovieList.remove(m);
                    break;
                }
            }
            MovieList = importedMovieList;
            AddMovieinFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }

    }

    public void UpdateMovie(char venue, String NewMovieName) {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
            ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
            is.close();
            for (Movie m : importedMovieList) {
                if (venue == m.getVenue()) {
                    importedMovieList.remove(m);
                    Movie newMovie = new Movie(NewMovieName, venue);
                    importedMovieList.add(newMovie);
                    break;
                }
            }
            MovieList = importedMovieList;
            AddMovieinFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }

    }

    public void DisplayMovie(Movie M) {
        System.out.println("Movie Name: " + M.getMovieName() + "\nMovie Venue: " + M.getVenue());
        System.out.println("");
    }

    public void DisplayAllMovies() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
            ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
            is.close();
            for (Movie m : importedMovieList) {
                DisplayMovie(m);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }
}
