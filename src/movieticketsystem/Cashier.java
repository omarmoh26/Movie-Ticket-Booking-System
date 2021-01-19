package movieticketsystem;

import java.io.*;
import java.util.*;

public class Cashier implements Serializable {

    private ArrayList<Ticket> TicketList = new ArrayList<>();
    private int ID;
    private String Name;

    private String TicketFilename = "Tickets.txt";

    public Cashier() {
    }

    public Cashier(int ID, String Name) {
        this.ID = ID;
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void AddTicket(Ticket e) {
        TicketList.add(e);
        AddTicketFile();
    }

    public void AddTicketFile() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(TicketFilename));
            os.writeObject(TicketList);
            os.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        }
    }

    public void CancelTicket(int SeatNUMBER) {

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(TicketFilename));
            ArrayList<Ticket> importedTicketList = (ArrayList<Ticket>) is.readObject();
            is.close();
            for (Ticket ticket : importedTicketList) {
                if (SeatNUMBER == ticket.getSeatNumber()) {
                    importedTicketList.remove(ticket);
                    break;
                }
            }
            TicketList = importedTicketList;
            AddTicketFile();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public void DisplayTicketData(Ticket T) {
        System.out.println("Customer Name: " + T.getCostumerName() + "\nMovie Name: " + T.getMovieName() + "\nTicket Time: " + T.getTime() + "\nVenue: " + T.getVenue() + "\nSeat Number: " + T.getSeatNumber() + "\nCategory: " + T.getCategory() + " -> " + T.getTicketPrice(T.getCategory()) + " EGP");
        System.out.println("");
    }

    public void DisplayAllTickets() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(TicketFilename));
            ArrayList<Ticket> TicketList = (ArrayList<Ticket>) is.readObject();
            is.close();
            for (Ticket ticket : TicketList) {
                DisplayTicketData(ticket);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found !!");
        } catch (IOException ex) {
            System.out.println("Input Output Exception !!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found  Exception !!");
        }
    }

    public int totalPayment(int ticketprice, int ticketNumbers) {
        return (ticketprice * ticketNumbers);
    }

}
