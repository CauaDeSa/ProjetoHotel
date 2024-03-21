package model.Entity.Accommodations;

import model.Entity.Persons.Guest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Guest responsibleGuest;
    private List<Guest> guests;
    private Accommodation accommodation;
    private CreditCard card;
    private double penalty;

    public Reservation(LocalDateTime checkIn, LocalDateTime checkOut,
                       Guest responsibleGuest, Accommodation accommodation,
                       CreditCard card) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.accommodation = accommodation;
        this.card = card;
        this.penalty = 0;

        guests = new ArrayList<Guest>();
        guests.add(responsibleGuest);
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public Guest getResponsibleGuest() {
        return guests.get(0);
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public CreditCard getCreditCard() {
        return card;
    }

    public double getPenalty() {
        return penalty;
    }

    public List<Guest> getAllGuests() {
        return guests;
    }

    public boolean insertGuest(Guest guest) {
        return guests.add(guest);
    }

    public boolean removeGuest(Guest guest) {
        return guests.remove(guest);
    }
}