package com.hospitalmanagementsystem.Hospital.Management.System.controller;


import com.hospitalmanagementsystem.Hospital.Management.System.models.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    // http://localhost:8080/patient/getAllPatient -> GetMethod
    @GetMapping("/getAllPatient")
    public List<Patient> getAllpatient(){
        return patientService.getAllPatient();
    }

    @PostMapping("/register")
    public String registerPatient(@RequestBody Patient p){
        patientService.register(p);
        return "Patient Added Sucessfully";
    }

    @GetMapping("")
    public Patient getById(@RequestParam UUID id){
        return patientService.getById(id);
    }
}

