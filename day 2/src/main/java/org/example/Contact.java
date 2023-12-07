package org.example;

public class Contact {
    public static int ID = 0;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contact(String firstNAme, String lastName, String email, String phoneNumber,RelationStatus relationStatus) {
        ID += 1;
        this.id = ID;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstNAme = firstNAme;
        this.lastName = lastName;
        this.relationStatus = relationStatus;
    }

    private String email;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", firstNAme='" + firstNAme + '\'' +
                ", lastName='" + lastName + '\'' +
                ", relationStatus=" + relationStatus +
                '}';
    }

    private String firstNAme;
    private String lastName;
    private RelationStatus relationStatus;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public RelationStatus getRelationStatus() {
        return relationStatus;
    }

    public void setRelationStatus(RelationStatus relationStatus) {
        this.relationStatus = relationStatus;
    }
}

enum RelationStatus {
    COLLEGE,
    FRIEND,
    NONE

}
