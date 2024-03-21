package model.enums;

public enum ItemType {
    LAVANDERIA("Lavanderia"),
    FRIGOBAR("Frigobar"),
    RESTAURANTE("Restaurante");

    private String itemType;

    ItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTipoItens() {
        return itemType;
    }
}