package com.example.lamthai.mathapp;

/**
 * Created by Thai on 12/5/2016.
 */
public class Student {
    private String firstName;
    private String lastName;
    private String id;

    public Student(String firstName, String lastName, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    public Student(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String toString(){
        return String.format("%s: %s %s%n %s: %s","Student name",getFirstName(),getLastName(),"Student ID",getId());
    }
}
