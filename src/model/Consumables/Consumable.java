package model.Consumables;

import model.enums.TipoItens;

public class Consumable {
    TipoItens type;
    String id;
    String description;
    double price;

    public Consumable(TipoItens type, String id, String description, double price) {
        this.type = type;
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public TipoItens getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
