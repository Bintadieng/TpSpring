package sn.isep.dbe.Gestion_De_File.model;

public class Ticket {
    private int number;
    private int peopleAhead;

    public Ticket(int number, int peopleAhead) {
        this.number = number;
        this.peopleAhead = peopleAhead;
    }

    // Getters et Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPeopleAhead() {
        return peopleAhead;
    }

    public void setPeopleAhead(int peopleAhead) {
        this.peopleAhead = peopleAhead;
    }
}