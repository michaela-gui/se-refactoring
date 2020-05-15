package de.michaelafleig.serefactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RentalTest {

    @Test
    void statement1() {
        Rental r = new Rental(new Movie("Test", Movie.NEW_RELEASE), 5);
        Customer c = new Customer("Er");
        c.addRental(r);
        assertEquals("Rental Record for Er\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t5\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points", c.statement());
    }

    @Test
    void statement2() {
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 5);
        Rental r2 = new Rental(new Movie("Test", Movie.REGULAR), 10);
        Customer c = new Customer("Er");
        c.addRental(r);
        c.addRental(r2);
        assertEquals("Rental Record for Er\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t5\t4.5\n" +
                "\tTest\t\t10\t14.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 2 frequent renter points", c.statement());
    }

    @Test
    void statement3() {
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 1);
        Rental r2 = new Rental(new Movie("Test", Movie.REGULAR), 2);
        Customer c = new Customer("Er");
        c.addRental(r);
        c.addRental(r2);
        assertEquals("Rental Record for Er\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t1\t1.5\n" +
                "\tTest\t\t2\t2.0\n" +
                "Amount owed is 3.5\n" +
                "You earned 2 frequent renter points", c.statement());
    }
}