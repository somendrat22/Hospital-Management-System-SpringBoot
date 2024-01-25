package com.hospitalmanagementsystem.Hospital.Management.System.service;

import com.hospitalmanagementsystem.Hospital.Management.System.models.Bed;
import com.hospitalmanagementsystem.Hospital.Management.System.models.Doctor;
import com.hospitalmanagementsystem.Hospital.Management.System.models.Patient;
import com.hospitalmanagementsystem.Hospital.Management.System.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    HospitalService hospitalService;

    @Autowired
    BedService bedService;

    @Autowired
    PatientRepository patientRepository;

    public void register(Patient obj){
        // 1. Generate UUID for the patient
        UUID id = UUID.randomUUID();
        obj.setpId(id);
        // 2. Get Doctor who is handeling minimum number of patient in that particular hospital
        Doctor doctor = hospitalService.getMinimumPatientDoctorInHospital(obj.getHospitalId());
        obj.setDocId(doctor.getDocId());
        doctor.getPatients().add(obj);
        // 3. Get UnOccupied bed
        Bed bed = bedService.getUnOccupiedBedInHospital(obj.getHospitalId());
        obj.setBedId(bed.getBedId());
        // 4. Set status fo the bed with the docId and patientId
        bed.setBooked(true);
        bed.setPatient(obj.getBedId());
        bed.setDoctor(doctor.getDocId());
        // 5. save patient to database
       patientRepository.registerPatient(obj);
    }
    public List<Patient> getAllPatient(){
        return patientRepository.getAllPatient();
    }

    public Patient getById(UUID id){

        return patientRepository.getById(id);
    }
}
