package de.michaelafleig.serefactoring;

class Rental {
    private Movie movie;
    private int daysRented;

    private Rental(Movie newMovie, int newDaysRented) {
        movie = newMovie;
        daysRented = newDaysRented;
    }

    public static Rental create(Movie newMovie, int newDaysRented)
    {
        return new Rental(newMovie, newDaysRented);
    }
    
    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}