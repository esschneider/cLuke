package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void movie_specialCode() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(1).withDayOfMonth(1));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));
        System.out.println(Duration.ofMinutes(90));
    }

    @Test
    void movie_1stSequence_specialCode_ThreeIsGreaterThan20Percent() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(1).withDayOfMonth(1));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_2ndSequence() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(1).withDayOfMonth(1));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_1stSequence_specialCode_20PercentIsGreaterThan3() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),100, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(1).withDayOfMonth(1));
        assertEquals(80, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_7thOfMonth() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withDayOfMonth(7).withHour(1));
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_11am() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),100, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(11).withDayOfMonth(1));
        assertEquals(75, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_4pm() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),100, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(16).withDayOfMonth(1));
        assertEquals(100, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_11am_1stSequence_25PercentMoreThan3Dollars() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),100, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(13).withDayOfMonth(1));
        assertEquals(75, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_11am_1stSequence_3DollarsMoreThan25Percent() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),9, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(13).withDayOfMonth(1));
        assertEquals(6, spiderMan.calculateTicketPrice(showing));
    }

    @Test
    void movie_11am_7thDay_1isMoreThan25Percent() {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),1, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now())
                .withHour(13).withDayOfMonth(7));
        assertEquals(0, spiderMan.calculateTicketPrice(showing));
    }
}
