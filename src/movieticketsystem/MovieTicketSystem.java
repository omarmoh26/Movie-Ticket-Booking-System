package movieticketsystem;

public class MovieTicketSystem {

    public static void main(String[] args) {
        LoginGUI l = new LoginGUI();
        //ManagerGUI login =new ManagerGUI();
        //CashierGUI Manager =new CashierGUI();
        Manager M = new Manager(12, "Omar", "omar12", "4321");
        
        Cashier Cashier = new Cashier(7, "Mohamed");
        M.AddCashier(Cashier);
        
        Movie movie1 = new Movie("Tenet", 'A');
        Movie movie2 = new Movie("Honest Thief", 'B');
        Movie movie3 = new Movie("Greenland", 'C');
        M.AddMovie(movie1);
        M.AddMovie(movie2);
        M.AddMovie(movie3);
        
        Ticket T1 = new Ticket("Maria","Tenet","12:00 pm",3,'A',"silver");
        Cashier.AddTicket(T1);
    }
}
