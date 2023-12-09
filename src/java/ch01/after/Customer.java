package ch01.after;

import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }
    public void addRental(Rental rental){
        rentals.add(rental);
    }
}
