package com.jpmc.theater;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Movie {
    private static int MOVIE_CODE_SPECIAL = 1;

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }

    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return ticketPrice - getDiscount(showing.getSequenceOfTheDay(), showing.getStartTime());
    }

    private double getDiscount(int showSequence, LocalDateTime movieStartTime) {
        double discount = 0;
        if (MOVIE_CODE_SPECIAL == specialCode) {
            discount = ticketPrice * 0.2;  // 20% discount for special movie
        }

        if (showSequence == 1 && 3 > discount) {
            discount = 3; // $3 discount for 1st show
        } else if (showSequence == 2 && 2 > discount) {
            discount = 2; // $2 discount for 2nd show
        }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }

        if (movieStartTime.getDayOfMonth() == 7 && 1 > discount) {
            discount = 1;
        }

        if (movieStartTime.getHour() >= 11 && movieStartTime.getHour() < 16 && ((ticketPrice * .25) > discount)) {
            discount = ticketPrice * 0.25;
        }

        // biggest discount wins
        return discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Double.compare(movie.ticketPrice, ticketPrice) == 0
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }

    public String toString()
    {
        return "{title: " + this.title + ", description: " + this.description + ", running_time: " + this.runningTime
                + ", ticket_price: " + this.ticketPrice + ", special_code: " + this.specialCode + "}";
    }
}