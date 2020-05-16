package de.michaelafleig.serefactoring;

import java.lang.*;

/**
 * Note that Java console applications need to be run through the java runtime
 * by running "java -jar JarFile.jar" in the command line.
 * Java console applications can not be previewed in the Compiler IDE, only applets can.
 */
public class Program {
    /**
     * This is the main entry point for the application
     */
    private static final int DAYS_RENTED_5  =  5;
    private static final int DAYS_RENTED_10 = 10;
    private static final String MOVIE_TITLE_1 = "movie1";
    private static final String MOVIE_TITLE_2 = "movie2";
    private static final String CUSTOMER_NAME_1 = "joe";


    public static void main(String args[]) {
        String result;
        System.out.println("Welcome to the de.michaelafleig.serefactoring.Movie Store");
        Movie movie1   = new Movie(MOVIE_TITLE_1, Movie.NEW_RELEASE);
        Movie movie2   = new Movie(MOVIE_TITLE_2, Movie.CHILDREN);
        Rental rental1 = new Rental(movie1, DAYS_RENTED_10);
        Rental rental2 = new Rental(movie2, DAYS_RENTED_5);
        Customer customer1 = new Customer(CUSTOMER_NAME_1);
        customer1.addRental(rental1);
        customer1.addRental(rental2);
        System.out.println("Let's get the Statement");
        result = customer1.statement();
        System.out.println(result);
    }
}


