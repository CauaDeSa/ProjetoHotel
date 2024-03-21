package model.Entity.Accommodations;

import model.Entity.Persons.Guest;

import java.time.LocalDateTime;

public class Occupation extends Reservation {
    private Employee responsibleEmployee;

    public Occupation(LocalDateTime checkIn, LocalDateTime checkOut,
                      Guest responsibleGuest, Accommodation accommodation,
                      Employee employee, CreditCard card) {
        super(checkIn, checkOut, responsibleGuest, accommodation, card);
        this.responsibleEmployee = employee;
    }

    public Occupation(Reservation previousReservation,
                      Employee responsibleEmployee) {
        super(previousReservation.getCheckIn(),
                previousReservation.getCheckOut(),
                previousReservation.getResponsibleGuest(),
                previousReservation.getAccommodation(),
                previousReservation.getCreditCard());
        this.responsibleEmployee = responsibleEmployee;
    }
}
