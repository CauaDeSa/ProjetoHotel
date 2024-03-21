package model.Entity.Persons;

import model.enums.States;

import java.time.LocalDate;

public class Employee extends Person {

    public Employee(String name, String telephone, String hometown, States homestate, LocalDate bornDate, String key) {
        super(name, telephone, hometown, homestate, bornDate, key);
    }

    @Override
    protected boolean password(String key) {
        return this.getKey().equals(key);
    }
}
