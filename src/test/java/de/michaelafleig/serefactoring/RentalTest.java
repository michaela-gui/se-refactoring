package de.michaelafleig.serefactoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RentalTest {

    private static final int NEW_DAYS_RENTED_1  =  1;
    private static final int NEW_DAYS_RENTED_2  =  2;
    private static final int NEW_DAYS_RENTED_5  =  5;
    private static final int NEW_DAYS_RENTED_10 = 10;
    private static final String NEW_TITLE_1 = "Test";
    private static final String NEW_NAME_1  = "Er";

    @Test
    void statement1() {
        Rental rental = new Rental(new Movie(NEW_TITLE_1, Movie.NEW_RELEASE), NEW_DAYS_RENTED_5);
        Customer customer = new Customer(NEW_NAME_1);
        customer.addRental(rental);
        assertEquals("Rental Record for Er\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t5\t15.0\n" +
                "Amount owed is 15.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }


    @Test
    void statement2() {
        Rental rental1 = new Rental(new Movie(NEW_TITLE_1, Movie.CHILDREN), NEW_DAYS_RENTED_5);
        Rental rental2 = new Rental(new Movie(NEW_TITLE_1, Movie.REGULAR), NEW_DAYS_RENTED_10);
        Customer customer = new Customer(NEW_NAME_1);
        customer.addRental(rental1);
        customer.addRental(rental2);
        assertEquals("Rental Record for Er\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t5\t4.5\n" +
                "\tTest\t\t10\t14.0\n" +
                "Amount owed is 18.5\n" +
                "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    void statement3() {
        Rental rental1 = new Rental(new Movie(NEW_TITLE_1, Movie.CHILDREN), NEW_DAYS_RENTED_1);
        Rental rental2 = new Rental(new Movie(NEW_TITLE_1, Movie.REGULAR), NEW_DAYS_RENTED_2);
        Customer customer = new Customer(NEW_NAME_1);
        customer.addRental(rental1);
        customer.addRental(rental2);
        assertEquals("Rental Record for Er\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tTest\t\t1\t1.5\n" +
                "\tTest\t\t2\t2.0\n" +
                "Amount owed is 3.5\n" +
                "You earned 2 frequent renter points", customer.statement());
    }
}