package de.michaelafleig.serefactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RentalTest {

    @Test
    void getAmount1() {
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
    void getAmount2() {
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 5);
        //assertEquals(4.5, r.getAmount());
    }

    @Test
    void getAmount3() {
        Rental r = new Rental(new Movie("Test", Movie.REGULAR), 5);
        //assertEquals(6.5, r.getAmount());
    }

    @Test
    void getAmount4() {
        Rental r = new Rental(new Movie("Test", Movie.NEW_RELEASE), 1);
        //assertEquals(3, r.getAmount());
    }

    @Test
    void getAmount5() {
        Rental r = new Rental(new Movie("Test", Movie.CHILDRENS), 1);
        //assertEquals(1.5, r.getAmount());
    }

    @Test
    void getAmount6() {
        Rental r = new Rental(new Movie("Test", Movie.REGULAR), 1);
        //assertEquals(2, r.getAmount());
    }
}