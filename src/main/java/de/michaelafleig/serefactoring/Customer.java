package de.michaelafleig.serefactoring;

import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector rentals;
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

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addToVar(double Var, double addVal)
    {
        Var += addVal;
        return;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental rental = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            //addToVar(thisAmount, amountFor(rental));
            thisAmount = amountFor(rental);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > DAYS_RENTED_1)
                frequentRenterPoints++;
            //show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            //addToVar(totalAmount, thisAmount);
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental rental) {
        double thisAmount = 0;

        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                //addToVar(thisAmount, DAYS_RENTED_2);
                thisAmount += DAYS_RENTED_2;
                if (rental.getDaysRented() > DAYS_RENTED_2)
                    //addToVar(thisAmount,(rental.getDaysRented() - DAYS_RENTED_2) * PRICE_PARAM_1_5);
                    thisAmount += (rental.getDaysRented() - DAYS_RENTED_2) * PRICE_PARAM_1_5;
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
                    thisAmount += (rental.getDaysRented() - DAYS_RENTED_3) * PRICE_PARAM_1_5;
                //else
                //    throw new OrderProcessingError(rental.getDaysRented() < DAYS_RENTED_3);
                break;
        }
        return thisAmount;
    }

}
    