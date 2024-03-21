package model.Entity.Persons;

import model.enums.States;

import java.time.LocalDate;

public abstract class Person {
    private String name;
    private String telephone;
    private String hometown;
    private States homestate;
    private LocalDate bornDate;
    private String key;

    public Person(String name, String telephone, String hometown,
                  States homestate,
                  LocalDate bornDate, String key) {
        this.name = name;
        this.telephone = telephone;
        this.hometown = hometown;
        this.homestate = homestate;
        this.bornDate = bornDate;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getHometown() {
        return hometown;
    }

    public States getHomeState() {
        return homestate;
    }

    public LocalDate getBornDate() {
        return bornDate;
    }

    public String getKey() {
        return key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public void setHomeState(States homestate) {
        this.homestate = homestate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean allowAccess(String key) {
        return password(key);
    }

    protected abstract boolean password(String key);
}
