package model.enums;

public enum Identification {
    CPF("CPF"),
    RG("RG"),
    PASSAPORTE("Passaporte");

    private String identification;

    Identification(String tipoDoc) {
    }

    public String getTipoDoc() {
    return identification;
    }
}