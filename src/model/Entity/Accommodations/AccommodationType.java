package model.Entity.Accommodations;

import model.Entity.Accommodations.AccommodationType;

public class AccommodationType {
    String identifier;
    String name;
    String description;
    int existingQuantity;
    int availableQuantity;
    double dailyPrice;
    int maxAdultsSupported;
    int maxKidsSupported;

    public AccommodationType(String identifier, String name,
                             String description, int existingQuantity,
                             int availableQuantity, double dailyPrice,
                             int maxAdultsSupported, int maxKidsSupported) {
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.existingQuantity = existingQuantity;
        this.availableQuantity = availableQuantity;
        this.dailyPrice = dailyPrice;
        this.maxAdultsSupported = maxAdultsSupported;
        this.maxKidsSupported = maxKidsSupported;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getExistingQuantity() {
        return existingQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public int getMaxAdultsAmount() {
        return maxAdultsSupported;
    }

    public int getMaxKidsAmount() {
        return maxKidsSupported;
    }

    public String getTipo() {
        return description;
    }
}
