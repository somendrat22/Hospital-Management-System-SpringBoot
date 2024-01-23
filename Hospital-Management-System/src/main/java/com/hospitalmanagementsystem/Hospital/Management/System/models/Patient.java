package com.hospitalmanagementsystem.Hospital.Management.System.models;

import java.util.UUID;

public class Patient {
    UUID pId;
    String name;
    String address;
    String disease;
    Long contactNumber;
    UUID docId;
    int age;
    String emailId;

    public Patient(UUID pId, String name, String address, String disease, Long contactNumber, UUID docId, int age, String emailId) {
        this.pId = pId;
        this.name = name;
        this.address = address;
        this.disease = disease;
        this.contactNumber = contactNumber;
        this.docId = docId;
        this.age = age;
        this.emailId = emailId;
    }


}
