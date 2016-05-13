package com.chiemy.example.databindingexample.bean;

/**
 * Created by hotbody on 16/5/13.
 */
public class User {
    private String firstName;
    private String lastName;
    private boolean isFriend;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setIsFriend(boolean isFriend) {
        this.isFriend = isFriend;
    }
}
