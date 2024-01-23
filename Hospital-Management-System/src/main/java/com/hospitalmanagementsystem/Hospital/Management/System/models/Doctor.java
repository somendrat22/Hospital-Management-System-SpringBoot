package com.hospitalmanagementsystem.Hospital.Management.System.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {
    UUID docId;
    String name;
    String degree;
    List<Patient> patients;
    UUID hospitalId;

    public Doctor(UUID docId, String name, String degree, List<Patient> patients, UUID hospitalId) {
        this.docId = docId;
        this.name = name;
        this.degree = degree;
        this.patients = new ArrayList<>();
        this.hospitalId = hospitalId;
    }
}
