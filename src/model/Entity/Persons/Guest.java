package model.Entity.Persons;

import model.Consumables.Consumption;
import model.enums.Identification;
import model.enums.States;
import model.pessoas.Funcionario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Guest extends Person{
    private String homeland;
    private String email;
    private Identification document;
    private String motherName;
    private String fatherName;
    private double telephoneExpenses;
    private List<Consumption> consumption;
    private Funcionario responsibleEmployee;

    public Guest(String name, String telephone, String hometown,
                 States homestate, LocalDate bornDate, String key,
                 String homeland, String email, Identification document, String motherName, String fatherName, Funcionario responsibleEmployee) {
        super(name, telephone, hometown, homestate, bornDate, key);
        this.homeland = homeland;
        this.email = email;
        this.document = document;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.responsibleEmployee = responsibleEmployee;
        this.telephoneExpenses = 0;
        this.consumption = new ArrayList<>();
    }

    public String getHomeland() {
        return homeland;
    }

    public String getEmail() {
        return email;
    }

    public Identification getDocument() {
        return document;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public double getTelephoneExpenses() {
        return telephoneExpenses;
    }

    public List<Consumption> getConsumption() {
        return consumption;
    }

    public Funcionario getResponsibleEmployee() {
        return responsibleEmployee;
    }

    @Override
    protected boolean password(String key) {
        return this.getKey().equals(key);
    }
}