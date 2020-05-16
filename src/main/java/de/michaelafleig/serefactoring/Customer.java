package de.michaelafleig.serefactoring;

//import java.lang.*;
import java.util.*;

class Customer {
    private final String name;
    private final Vector rentals;
    private static final double PRICE_PARAM_1_5 = 1.5;
    private static final int DAYS_RENTED_1 = 1;
    private static final int DAYS_RENTED_2 = 2;
    private static final int DAYS_RENTED_3 = 3;

    private Customer(String newName) {
        name = newName;
        rentals = new Vector();
    }

    public static Customer create(String newName)
    {
        return new Customer(newName);
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount;
        totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals;
        enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        StringBuilder resultBuilder = new StringBuilder(result);
        while (enum_rentals.hasMoreElements()) {
            double thisAmount;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            //addToVar(thisAmount, amountFor(rental));
            thisAmount = amountFor(rental);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > DAYS_RENTED_1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            resultBuilder.append("\t").append(rental.getMovie().getTitle()).append("\t").append("\t").append(rental.getDaysRented()).append("\t").append(thisAmount).append("\n");
            //addToVar(totalAmount, thisAmount);
            totalAmount += thisAmount;
        }
        result = resultBuilder.toString();
        //add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double thisAmount = 0;
        int priceCode = rental.getMovie().getPriceCode();

        switch (priceCode) {
            case Movie.REGULAR:
                //addToVar(thisAmount, DAYS_RENTED_2);
                thisAmount += DAYS_RENTED_2;
                if (rental.getDaysRented() > DAYS_RENTED_2)
                    //addToVar(thisAmount,(rental.getDaysRented() - DAYS_RENTED_2) * PRICE_PARAM_1_5);
                {
                    thisAmount += (rental.getDaysRented() - DAYS_RENTED_2) * PRICE_PARAM_1_5;
                }
                //else
                //    throw new OrderProcessingError(rental.getDaysRented() < DAYS_RENTED_2);
                break;
            case Movie.NEW_RELEASE:
                //addToVar(thisAmount, rental.getDaysRented() * DAYS_RENTED_3);
                thisAmount += rental.getDaysRented() * DAYS_RENTED_3;
                break;
            case Movie.CHILDREN:
                //addToVar(thisAmount, PRICE_PARAM_1_5);
                thisAmount += PRICE_PARAM_1_5;
                if (rental.getDaysRented() > DAYS_RENTED_3)
                    //addToVar(thisAmount, (rental.getDaysRented() - DAYS_RENTED_3) * PRICE_PARAM_1_5);
                {
                    thisAmount += (rental.getDaysRented() - DAYS_RENTED_3) * PRICE_PARAM_1_5;
                }
                //else
                //    throw new OrderProcessingError(rental.getDaysRented() < DAYS_RENTED_3);
                break;
        }
        return thisAmount;
    }

}
    