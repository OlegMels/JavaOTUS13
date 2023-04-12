package src.model;

public class Account {
    private int id;
    private String number;

    private Client client;

    public Account() {}


    public Account(int id, String number, Client client) {
        this.id = id;
        this.number = number;
        this.client = client;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
