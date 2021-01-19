package movieticketsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class ManagerGUI extends JFrame implements ActionListener {

    private ArrayList<Movie> MovieList = new ArrayList<>();
    private ArrayList<Cashier> CashierList = new ArrayList<>();
    private String CashierFilename = "Cashiers.txt";
    private String MovieFilename = "Movies.txt";

    Container container = getContentPane();

    JLabel cashierName = new JLabel("Cashier Name: ");
    JTextField CashierNameText = new JTextField();

    JLabel cashierID = new JLabel("Cashier ID: ");
    JTextField CashierIDtext = new JTextField();

    JLabel movieVenue = new JLabel("Movie Venue: ");
    JTextField MovieVenueText = new JTextField();

    JLabel movieName = new JLabel("Movie Name: ");
    JTextField MovieNameText = new JTextField();

    JButton AddCashierButton = new JButton("Add");
    JButton RemoveCashierButton = new JButton("Remove");
    JButton UpdateCashierButton = new JButton("Update");

    JButton AddMovieButton = new JButton("Add");
    JButton RemoveMovieButton = new JButton("Remove");
    JButton UpdateMovieButton = new JButton("Update");

    JButton Cashier = new JButton("Cashier");
    JButton Movie = new JButton("Movie");

    JToggleButton AddCashier = new JToggleButton("Add");
    JToggleButton RemoveCashier = new JToggleButton("Remove");
    JToggleButton UpdateCashier = new JToggleButton("Update");
    JToggleButton ViewCashier = new JToggleButton("View");
    ButtonGroup groupCashier = new ButtonGroup();
    JToggleButton AddMovie = new JToggleButton("Add");
    JToggleButton RemoveMovie = new JToggleButton("Remove");
    JToggleButton UpdateMovie = new JToggleButton("Update");
    JToggleButton ViewMovie = new JToggleButton("View");
    ButtonGroup groupMovie = new ButtonGroup();

    ManagerGUI() {

        setTitle("Manager");
        setVisible(true);
        setBounds(360, 140, 600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addActionEvent();
        container.add(Cashier);
        container.add(Movie);
        groupCashier.add(AddCashier);
        groupCashier.add(RemoveCashier);
        groupCashier.add(UpdateCashier);
        groupCashier.add(ViewCashier);
        groupMovie.add(AddMovie);
        groupMovie.add(RemoveMovie);
        groupMovie.add(UpdateMovie);
        groupMovie.add(ViewMovie);
        // addComponentsToContainer();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        Cashier.setBounds(55, 120, 200, 200);
        Movie.setBounds(355, 120, 200, 200);

        cashierName.setBounds(100, 100, 100, 30);
        cashierID.setBounds(100, 170, 100, 30);

        CashierNameText.setBounds(200, 100, 150, 30);
        CashierIDtext.setBounds(200, 170, 150, 30);

        movieVenue.setBounds(100, 100, 100, 30);
        movieName.setBounds(100, 170, 100, 30);

        MovieVenueText.setBounds(200, 100, 150, 30);
        MovieNameText.setBounds(200, 170, 150, 30);

        ViewCashier.setBounds(100, 0, 70, 40);
        AddCashier.setBounds(200, 0, 70, 40);
        RemoveCashier.setBounds(300, 0, 100, 40);
        UpdateCashier.setBounds(430, 0, 100, 40);

        ViewMovie.setBounds(100, 0, 70, 40);
        AddMovie.setBounds(200, 0, 70, 40);
        RemoveMovie.setBounds(300, 0, 100, 40);
        UpdateMovie.setBounds(430, 0, 100, 40);

        AddCashierButton.setBounds(100, 250, 100, 30);
        AddMovieButton.setBounds(100, 250, 100, 30);
        RemoveCashierButton.setBounds(100, 250, 100, 30);
        RemoveMovieButton.setBounds(100, 250, 100, 30);
        UpdateMovieButton.setBounds(100, 250, 100, 30);
        UpdateCashierButton.setBounds(100, 250, 100, 30);

    }

    public void CahsierViewComponents() {

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
            ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
            is.close();
            int i = 0;
            for (Cashier u1 : importedCashierList) {
                StringBuilder ID = new StringBuilder();
                StringBuilder Name = new StringBuilder();
                ID.append("\n" + "ID: " + +u1.getID());
                Name.append("\n" + "Name: " + u1.getName());
                JLabel Label = new JLabel(ID.toString());
                JLabel Label1 = new JLabel(Name.toString());
                Label.setBounds(50, 100 + i, 600, 30);
                Label1.setBounds(50, 125 + i, 600, 30);
                container.add(Label);
                container.add(Label1);
                i += 50;
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void MovieViewComponents() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
            ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
            is.close();
            int i = 0;
            for (Movie m : importedMovieList) {
                StringBuilder Venue = new StringBuilder();
                StringBuilder MovieName = new StringBuilder();
                Venue.append("\n" + "Venue: " + m.getVenue());
                MovieName.append("\n" + "Movie Name: " + m.getMovieName());
                JLabel Label = new JLabel(Venue.toString());
                JLabel Label1 = new JLabel(MovieName.toString());
                Label.setBounds(50, 100 + i, 600, 30);
                Label1.setBounds(50, 125 + i, 600, 30);
                container.add(Label);
                container.add(Label1);
                i += 50;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }

    }

    public void addDefaultCashierComponents() {
        container.add(AddCashier);
        container.add(RemoveCashier);
        container.add(UpdateCashier);
        container.add(ViewCashier);
    }

    public void addDefaultMovieComponents() {
        container.add(AddMovie);
        container.add(RemoveMovie);
        container.add(UpdateMovie);
        container.add(ViewMovie);
    }

    public void addCashierComponents() {
        container.add(cashierName);
        container.add(cashierID);
        container.add(CashierNameText);
        container.add(CashierIDtext);
        container.add(AddCashierButton);

    }

    public void RemoveCashierComponents() {
        container.add(cashierID);
        container.add(CashierIDtext);
        container.add(RemoveCashierButton);

    }

    public void UpdateCashierComponents() {
        container.add(cashierID);
        container.add(cashierName);
        container.add(CashierIDtext);
        container.add(CashierNameText);
        container.add(UpdateCashierButton);

    }

    public void addMovieComponents() {

        container.add(movieVenue);
        container.add(movieName);
        container.add(MovieVenueText);
        container.add(MovieNameText);
        container.add(AddMovieButton);
    }

    public void RemoveMovieComponents() {
        container.add(movieName);
        container.add(MovieNameText);
        container.add(RemoveMovieButton);
    }

    public void UpdateMovieComponents() {
        container.add(movieVenue);
        container.add(movieName);
        container.add(MovieVenueText);
        container.add(MovieNameText);
        container.add(UpdateMovieButton);
    }

    public void addActionEvent() {
        Cashier.addActionListener(this);
        Movie.addActionListener(this);
        AddCashierButton.addActionListener(this);
        AddMovieButton.addActionListener(this);
        RemoveMovieButton.addActionListener(this);
        RemoveCashierButton.addActionListener(this);
        UpdateMovieButton.addActionListener(this);
        UpdateCashierButton.addActionListener(this);
        ViewCashier.addActionListener(this);
        AddCashier.addActionListener(this);
        RemoveCashier.addActionListener(this);
        UpdateCashier.addActionListener(this);
        ViewMovie.addActionListener(this);
        AddMovie.addActionListener(this);
        RemoveMovie.addActionListener(this);
        UpdateMovie.addActionListener(this);
    }

    public void fillCashierList() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
            ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
            is.close();
            CashierList = importedCashierList;
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void fillMovieList() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
            ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
            is.close();
            MovieList = importedMovieList;
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Cashier) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultCashierComponents();
        }
        if (e.getSource() == Movie) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultMovieComponents();
        }
        if (e.getSource() == ViewCashier) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultCashierComponents();
            CahsierViewComponents();
        }
        if (e.getSource() == AddCashier) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultCashierComponents();
            addCashierComponents();
        }
        if (e.getSource() == RemoveCashier) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultCashierComponents();
            RemoveCashierComponents();

        }
        if (e.getSource() == UpdateCashier) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultCashierComponents();
            UpdateCashierComponents();
        }
        if (e.getSource() == ViewMovie) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultMovieComponents();
            MovieViewComponents();

        }
        if (e.getSource() == AddMovie) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultMovieComponents();
            addMovieComponents();
        }
        if (e.getSource() == RemoveMovie) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultMovieComponents();
            RemoveMovieComponents();

        }
        if (e.getSource() == UpdateMovie) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultMovieComponents();
            UpdateMovieComponents();
        }

        if (e.getSource() == AddCashierButton) {
            String CashierName;
            String CashierID;
            int ID;
            CashierName = CashierNameText.getText();
            CashierID = CashierIDtext.getText();
            if (!CashierName.isEmpty() && !CashierID.isEmpty()) {
                ID = Integer.parseInt(CashierID);
                Cashier newCashier = new Cashier(ID, CashierName);
                fillCashierList();
                CashierList.add(newCashier);
                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(CashierFilename));
                    os.writeObject(CashierList);
                    os.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                }
                JOptionPane.showMessageDialog(this, "Cashier has been added successfully");
                CashierNameText.setText("");
                CashierIDtext.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter Name and ID");
            }

        }
        if (e.getSource() == RemoveCashierButton) {
            String CashierID;
            int ID;
            CashierID = CashierIDtext.getText();
            if (!CashierID.isEmpty()) {
                ID = Integer.parseInt(CashierID);
                try {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
                    ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
                    is.close();
                    for (Cashier cashier : importedCashierList) {
                        if (ID == cashier.getID()) {
                            importedCashierList.remove(cashier);
                            break;
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Cashier has been removed successfully");
                    CashierIDtext.setText("");
                    CashierList = importedCashierList;
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(CashierFilename));
                        os.writeObject(CashierList);
                        os.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("File Not Found !!");
                    } catch (IOException ex) {
                        System.out.println("Input Output Exception !!");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class Not Found  Exception !!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Enter ID");
            }
        }
        if (e.getSource() == UpdateCashierButton) {
            String CashierName;
            String CashierID;
            int ID;
            CashierName = CashierNameText.getText();
            CashierID = CashierIDtext.getText();
            if (!CashierName.isEmpty() && !CashierID.isEmpty()) {
                ID = Integer.parseInt(CashierID);
                try {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(CashierFilename));
                    ArrayList<Cashier> importedCashierList = (ArrayList<Cashier>) is.readObject();
                    is.close();
                    for (Cashier cashier : importedCashierList) {
                        if (ID == cashier.getID()) {
                            importedCashierList.remove(cashier);
                            Cashier newCashier = new Cashier(ID, CashierName);
                            importedCashierList.add(newCashier);
                            break;
                        }
                    }
                    CashierList = importedCashierList;
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(CashierFilename));
                        os.writeObject(CashierList);
                        os.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("File Not Found !!");
                    } catch (IOException ex) {
                        System.out.println("Input Output Exception !!");
                    }
                    JOptionPane.showMessageDialog(this, "Cashier has been updated successfully");
                    CashierNameText.setText("");
                    CashierIDtext.setText("");

                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class Not Found  Exception !!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Enter Name and ID");
            }
        }

        if (e.getSource() == AddMovieButton) {
            String MovieVenue;
            String MovieName;
            char Venue;
            MovieVenue = MovieVenueText.getText();
            MovieName = MovieNameText.getText();
            if (!MovieVenue.isEmpty() && !MovieName.isEmpty()) {
                MovieVenue = MovieVenue.toUpperCase();
                Venue = MovieVenue.charAt(0);
                Movie newmovie = new Movie(MovieName, Venue);
                fillMovieList();
                MovieList.add(newmovie);
                try {
                    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MovieFilename));
                    os.writeObject(MovieList);
                    os.close();
                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                }
                JOptionPane.showMessageDialog(this, "Movie has been added successfully");
                MovieVenueText.setText("");
                MovieNameText.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Enter Name and ID");
            }

        }
        if (e.getSource() == RemoveMovieButton) {
            String MovieName;
            MovieName = MovieNameText.getText();
            if (!MovieName.isEmpty()) {
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
                    JOptionPane.showMessageDialog(this, "Movie has been removed successfully");
                    MovieNameText.setText("");
                    MovieList = importedMovieList;
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MovieFilename));
                        os.writeObject(MovieList);
                        os.close();

                    } catch (FileNotFoundException ex) {
                        System.out.println("File Not Found !!");
                    } catch (IOException ex) {
                        System.out.println("Input Output Exception !!");
                    }

                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class Not Found  Exception !!");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Enter Movie Name");
            }
        }
        if (e.getSource() == UpdateMovieButton) {
            String MovieVenue;
            String MovieName;
            char Venue;
            MovieVenue = MovieVenueText.getText();
            MovieName = MovieNameText.getText();
            if (!MovieVenue.isEmpty() && !MovieName.isEmpty()) {
                MovieVenue = MovieVenue.toUpperCase();
                Venue = MovieVenue.charAt(0);
                try {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
                    ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
                    is.close();
                    for (Movie m : importedMovieList) {
                        if (Venue == m.getVenue()) {
                            importedMovieList.remove(m);
                            Movie newMovie = new Movie(MovieName, Venue);
                            importedMovieList.add(newMovie);
                            break;
                        }
                    }
                    MovieList = importedMovieList;
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(MovieFilename));
                        os.writeObject(MovieList);
                        os.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("File Not Found !!");
                    } catch (IOException ex) {
                        System.out.println("Input Output Exception !!");
                    }
                    JOptionPane.showMessageDialog(this, "Movie has been updated successfully");
                    MovieVenueText.setText("");
                    MovieNameText.setText("");

                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class Not Found  Exception !!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Enter Name and ID");
            }
        }
    }
}
