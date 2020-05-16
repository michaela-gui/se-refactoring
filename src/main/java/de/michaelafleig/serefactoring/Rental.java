package de.michaelafleig.serefactoring;

class Rental {
    private final Movie movie;
    private final int daysRented;

    private Rental(Movie newMovie, int newDaysRented) {
        movie = newMovie;
        daysRented = newDaysRented;
    }

    public static Rental create(Movie newMovie, int newDaysRented)
    {
        Rental rental = new Rental(newMovie, newDaysRented);
        return rental;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }
}