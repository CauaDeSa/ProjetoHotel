package model.Consumables;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consumption {
    LocalDateTime consumptionDate;
    String responsibleEmployee;
    Consumable consumedItem;
    int quantity;

    public Consumption(LocalDateTime consumptionDate, String responsibleEmployee, Consumable consumedItem, int quantity) {
        this.consumptionDate = LocalDateTime.now();
        this.responsibleEmployee = responsibleEmployee;
        this.consumedItem = consumedItem;
        this.quantity = quantity;
    }

    public LocalDateTime getConsumptionDate() {
        return consumptionDate;
    }

    public String getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public Consumable getConsumedItem() {
        return consumedItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalValue() {
        return consumedItem.getPrice() * quantity;
    }
}