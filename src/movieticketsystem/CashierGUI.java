package movieticketsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class CashierGUI extends JFrame implements ActionListener {

    private ArrayList<Ticket> TicketList = new ArrayList<>();

    private String MovieFilename = "Movies.txt";
    private String TicketFilename = "Tickets.txt";

    private String VenueAFilename = "Venue A.txt";
    private String VenueBFilename = "Venue B.txt";
    private String VenueCFilename = "Venue C.txt";

    Container container = getContentPane();
    ButtonGroup group = new ButtonGroup();

    JToggleButton Add = new JToggleButton("Add");
    JToggleButton Remove = new JToggleButton("Remove");
    JToggleButton View = new JToggleButton("View");

    JLabel CustomerName = new JLabel("Costumer Name: ");
    JTextField CustomerNameText = new JTextField();

    JLabel DateTime = new JLabel("Date and Time: ");
    JComboBox movie_Times = new JComboBox(new String[]{"12:00 pm", "4:00 pm", "8:00 pm", "12:00 am"});

    JLabel Movie = new JLabel("Movie: ");
    JComboBox movie_Names = new JComboBox(new String[]{"Tenet", "Honest Thief", "Greenland"});

    JLabel Category = new JLabel("Category: ");
    JComboBox Category_Names = new JComboBox(new String[]{"Silver", "Gold", "Platinum"});

    JLabel Seats = new JLabel("Seats: ");
    JComboBox Seats_NUM = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
    JLabel ScreenButton = new JLabel("S C R E E N", SwingConstants.CENTER);

    JButton ADDConfrimButton = new JButton("Confrim");
    JButton RemoveConfrimButton = new JButton("Remove");

    JLabel MovieNametoRemove = new JLabel("Movie Name: ");
    JTextField MovieNametoRemoveText = new JTextField();

    JLabel SeatNumbertoRemove = new JLabel("Seat Number: ");
    JTextField SeatNumbertoRemoveText = new JTextField();

    CashierGUI() {

        setTitle("Cashier");
        setVisible(true);
        setBounds(360, 140, 600, 500);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayoutManager();
        setLocationAndSize();
        addActionEvent();
        addDefaultComponentsToContainer();
        group.add(Add);
        group.add(Remove);
        group.add(View);

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {

        Add.setBounds(20, 0, 180, 40);
        Remove.setBounds(210, 0, 180, 40);
        View.setBounds(400, 0, 180, 40);

        CustomerName.setBounds(60, 80, 180, 30);
        CustomerNameText.setBounds(160, 80, 150, 30);

        DateTime.setBounds(60, 120, 180, 30);
        movie_Times.setBounds(160, 120, 80, 30);
        movie_Times.setSelectedItem(null);

        Movie.setBounds(60, 160, 180, 30);
        movie_Names.setBounds(160, 160, 80, 30);
        movie_Names.setSelectedItem(null);

        Category.setBounds(60, 200, 180, 30);
        Category_Names.setBounds(160, 200, 80, 30);
        Category_Names.setSelectedItem(null);

        Seats.setBounds(60, 240, 180, 30);
        Seats_NUM.setBounds(160, 240, 80, 30);
        Seats_NUM.setSelectedItem(null);

        ScreenButton.setOpaque(true);
        ScreenButton.setBackground(Color.YELLOW);
        ScreenButton.setForeground(Color.BLACK);
        ADDConfrimButton.setBounds(450, 240, 80, 30);
        ScreenButton.setBounds(60, 280, 480, 20);

        MovieNametoRemove.setBounds(150, 120, 180, 30);
        MovieNametoRemoveText.setBounds(250, 120, 180, 30);
        SeatNumbertoRemove.setBounds(150, 160, 180, 30);
        SeatNumbertoRemoveText.setBounds(250, 160, 180, 30);
        RemoveConfrimButton.setBounds(450, 240, 80, 30);
    }

    public void AddingComponents() {
        container.add(CustomerName);
        container.add(CustomerNameText);
        container.add(DateTime);
        container.add(movie_Times);
        container.add(Movie);
        container.add(movie_Names);
        container.add(Category);
        container.add(Category_Names);
        container.add(Seats);
        container.add(Seats_NUM);
        container.add(ScreenButton);
        int x = 0, y = 300;
        for (int i = 1; i <= 30; i++) {
            JLabel Seat = new JLabel("" + i);

            container.add(Seat);
            if (i == 10 || i == 20) {
                Seat.setBounds(60 + x, y, 50, 50);
                y = y + 40;
                x = 0;
            } else {
                Seat.setBounds(60 + x, y, 50, 50);
                x += 51;
            }

            Seat.setBackground(Color.YELLOW);
            Seat.setForeground(Color.BLACK);
        }

        container.add(ADDConfrimButton);

    }

    public void addDefaultComponentsToContainer() {
        container.add(Add);
        container.add(Remove);
        container.add(View);
    }

    public void viewTicketsCmponent() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(TicketFilename));
            ArrayList<Ticket> importedTicketsList = (ArrayList<Ticket>) is.readObject();
            is.close();
            int i = 0;
            for (Ticket t : importedTicketsList) {
                StringBuilder CustomerName = new StringBuilder();
                StringBuilder MovieName = new StringBuilder();
                StringBuilder TicketTime = new StringBuilder();
                StringBuilder Venue = new StringBuilder();
                StringBuilder SeatNumber = new StringBuilder();
                StringBuilder Category = new StringBuilder();
                StringBuilder Price = new StringBuilder();

                CustomerName.append("\n" + "CustomerName: " + t.getCostumerName());
                MovieName.append("\n" + "Movie Name: " + t.getMovieName());
                TicketTime.append("\n" + "Ticket Time: " + t.getTime());
                Venue.append("\n" + "Venue: " + t.getVenue());
                SeatNumber.append("\n" + "Seat Number: " + t.getSeatNumber());
                Category.append("\n" + "Category: " + t.getCategory());
                Price.append("\n" + "Price: " + t.getTicketPrice(t.getCategory()));

                JLabel CustomerNameLabel = new JLabel(CustomerName.toString());
                JLabel MovieNameLabel = new JLabel(MovieName.toString());
                JLabel TicketTimeLabel = new JLabel(TicketTime.toString());
                JLabel VenueLabel = new JLabel(Venue.toString());
                JLabel SeatNumberLabel = new JLabel(SeatNumber.toString());
                JLabel CategoryLabel = new JLabel(Category.toString());
                JLabel PriceLabel = new JLabel(Price.toString());

                CustomerNameLabel.setBounds(50, 100 + i, 600, 30);
                MovieNameLabel.setBounds(50, 125 + i, 600, 30);
                TicketTimeLabel.setBounds(50, 150 + i, 600, 30);
                VenueLabel.setBounds(50, 175 + i, 600, 30);
                SeatNumberLabel.setBounds(50, 200 + i, 600, 30);
                CategoryLabel.setBounds(50, 225 + i, 600, 30);
                PriceLabel.setBounds(50, 250 + i, 600, 30);

                container.add(CustomerNameLabel);
                container.add(MovieNameLabel);
                container.add(TicketTimeLabel);
                container.add(VenueLabel);
                container.add(SeatNumberLabel);
                container.add(CategoryLabel);
                container.add(PriceLabel);
                i += 200;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void importTicketFromFile() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(TicketFilename));
            ArrayList<Ticket> importedTicketList = (ArrayList<Ticket>) is.readObject();
            is.close();
            TicketList = importedTicketList;
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void RemoveMovieComponents() {
        container.add(MovieNametoRemove);
        container.add(MovieNametoRemoveText);
        container.add(SeatNumbertoRemove);
        container.add(SeatNumbertoRemoveText);
        container.add(RemoveConfrimButton);
    }

    public void addActionEvent() {
        Add.addActionListener(this);
        Remove.addActionListener(this);
        View.addActionListener(this);
        ADDConfrimButton.addActionListener(this);
        RemoveConfrimButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Add) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultComponentsToContainer();
            AddingComponents();
        }
        if (e.getSource() == Remove) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultComponentsToContainer();
            RemoveMovieComponents();
        }
        if (e.getSource() == View) {
            getContentPane().removeAll();
            getContentPane().repaint();
            addDefaultComponentsToContainer();
            viewTicketsCmponent();

        }
        if (e.getSource() == RemoveConfrimButton) {
            String RemovingMovieName;
            RemovingMovieName = (String) MovieNametoRemoveText.getText();
            int RemovingSeatNum;
            RemovingSeatNum = Integer.parseInt(SeatNumbertoRemoveText.getText());
            char venue = ' ';
            if (!RemovingMovieName.isEmpty() && RemovingSeatNum != 0) {
                boolean removed = false;
                try {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(TicketFilename));
                    ArrayList<Ticket> importedTicketList = (ArrayList<Ticket>) is.readObject();
                    is.close();

                    for (Ticket t : importedTicketList) {
                        if (t.getMovieName().equals(RemovingMovieName) && t.getSeatNumber() == RemovingSeatNum) {
                            importedTicketList.remove(t);
                            removed = true;
                            break;
                        }
                    }
                    TicketList = importedTicketList;
                } catch (FileNotFoundException ex) {
                    System.out.println("File Not Found !!");
                } catch (IOException ex) {
                    System.out.println("Input Output Exception !!");
                } catch (ClassNotFoundException ex) {
                    System.out.println("Class Not Found  Exception !!");
                }
                if (removed) {
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(TicketFilename));
                        os.writeObject(TicketList);
                        os.close();
                    } catch (FileNotFoundException ex) {
                        System.out.println("File Not Found !!");
                    } catch (IOException ex) {
                        System.out.println("Input Output Exception !!");
                    }
                    JOptionPane.showMessageDialog(this, "Ticket has been Deleted successfully");
                    MovieNametoRemoveText.setText("");
                    SeatNumbertoRemoveText.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Ticket is not found!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Fill all the fields!!");
            }
        }

        if (e.getSource() == ADDConfrimButton) {

            String newCustomername;
            newCustomername = CustomerNameText.getText();
            String newMtime;
            newMtime = (String) movie_Times.getSelectedItem();
            String newMname;
            newMname = (String) movie_Names.getSelectedItem();
            String newCategory;
            newCategory = (String) Category_Names.getSelectedItem();
            int newSeatNum;
            newSeatNum = Seats_NUM.getSelectedIndex() + 1;
            char venue = ' ';
            if (!newCustomername.isEmpty() && !newMtime.isEmpty() && !newMname.isEmpty() && !newCategory.isEmpty() && newSeatNum != 0) {
                try {
                    ObjectInputStream is = new ObjectInputStream(new FileInputStream(MovieFilename));
                    ArrayList<Movie> importedMovieList = (ArrayList<Movie>) is.readObject();
                    is.close();
                    for (Movie m : importedMovieList) {
                        if (m.getMovieName().equals(newMname)) {
                            venue = m.getVenue();
                            break;
                        }
                    }
                    importTicketFromFile();
                    Ticket T1 = new Ticket(newCustomername, newMname, newMtime, newSeatNum, venue, newCategory);
                    TicketList.add(T1);
                    try {
                        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(TicketFilename));
                        os.writeObject(TicketList);
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

                JOptionPane.showMessageDialog(this, "New Ticket for: " + newCustomername + " \nhas been booked successfully");
                CustomerNameText.setText("");
                movie_Times.setSelectedItem(null);
                Seats_NUM.setSelectedItem(null);
                Category_Names.setSelectedItem(null);
                movie_Names.setSelectedItem(null);

            } else {
                JOptionPane.showMessageDialog(this, "Fill all the fields!!");
            }

        }
    }
}
