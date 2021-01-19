package movieticketsystem;

public abstract class Data {

    private int ID;
    private String Name;
    private String UserName;
    private String Password;

    public Data() {
    }

    public Data(int ID, String Name, String UserName, String Password) {
        this.ID = ID;
        this.Name = Name;
        this.UserName = UserName;
        this.Password = Password;

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

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
