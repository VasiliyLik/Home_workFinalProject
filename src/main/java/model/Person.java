package model;

import interfacesAndAnnotations.MyAnnotationForGenerate;

public class Person {
    @MyAnnotationForGenerate
    private String firstName;
    @MyAnnotationForGenerate
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
