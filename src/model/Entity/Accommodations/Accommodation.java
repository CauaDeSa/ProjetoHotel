package model.Entity.Accommodations;

import model.Consumables.Consumption;

import java.util.List;

public class Accommodation {
    private int number;
    private int floor;
    private AccommodationType type;
    private List<Consumption> minibar;

    public Accommodation (int number, int floor, AccommodationType type) {
        this.number = number;
        this.floor = floor;
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public AccommodationType getType() {
        return type;
    }
}
