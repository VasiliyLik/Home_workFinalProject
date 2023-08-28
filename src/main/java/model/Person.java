package model;

import interfacesAndAnnotations.Generate;

public class Person {
    @Generate
    private String firstName;
    @Generate
    private String surName;

    Person(String firstName, String surName) {
        this.firstName = firstName;
        this.surName = surName;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
