package com.kodilla.testing.library;

import java.util.Objects;
public class LibraryUser {
    private String firstname;
    private String lastname;
    private String peselID;

    public LibraryUser(String firstname, String lastname, String peselID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.peselID = peselID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPeselID() {
        return peselID;
    }

    public void setPeselID(String peselID) {
        this.peselID = peselID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryUser that = (LibraryUser) o;
        return firstname.equals(that.firstname) && lastname.equals(that.lastname) && peselID.equals(that.peselID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, peselID);
    }

}
