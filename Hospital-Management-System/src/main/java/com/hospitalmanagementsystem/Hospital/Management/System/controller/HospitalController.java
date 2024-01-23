package com.hospitalmanagementsystem.Hospital.Management.System.controller;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Hospital;
import com.hospitalmanagementsystem.Hospital.Management.System.service.HospitalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is going to be a rest api thats why we are writing rest controller
@RestController
@RequestMapping("/hospital")
public class HospitalController {
    HospitalService hospitalService = new HospitalService();

    // http://localhost:8080/hospital/getAllHospital -> GetMethod
    @GetMapping("/getAllHospital")
    public List<Hospital> getAllHospital(){
        return hospitalService.getAllHospital();
    }

    @PostMapping("/register")
    public String registerHospital(@RequestBody Hospital obj){
        System.out.println(obj);
        hospitalService.registerHospital(obj);
        return "Hospital Added Successfully";
    }



}
