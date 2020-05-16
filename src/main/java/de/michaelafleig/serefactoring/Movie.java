package de.michaelafleig.serefactoring;

import java.util.HashSet;

public class Movie {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;

    private Movie(String newTitle, int newPriceCode)
    {
        title = newTitle;
        priceCode = newPriceCode;
    }
    public static Movie create(String newTitle, int newPriceCode) {
        Movie movie = new Movie(newTitle, newPriceCode);
        return movie;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public String getTitle() {
        return title;
    }
}