package ru.mirea.task14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.task14.components.Doctor;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.services.DoctorService;
import ru.mirea.task14.services.PatientService;

@Controller

@RequestMapping("/hospital")
public class HospitalController {

    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public HospitalController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/add/doctor")
    public String addDoctor(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String position) {
        Doctor doctor = new Doctor(firstName, lastName, position);
        doctorService.addDoctor(doctor);
        return "home";
    }

    @GetMapping("/delete/doctor")
    public String deleteDoctor(@RequestParam int id) {
        try {
            doctorService.deleteDoctor(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @GetMapping("/getall/doctor")
    public String getAllDoctors() {
        doctorService.getAllDoctors();
        return "home";
    }

    @GetMapping("/getpatients/doctor")
    public String getDoctor(@RequestParam int id){
        doctorService.getDoctorPatients(id);
        return "home";
    }

    @GetMapping("/add/patient")
    public String addPatient(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int doctor_id) {
       Patient patient = new Patient();
       patient.setFirstName(firstName);
       patient.setLastName(lastName);
       patient.setDoctor(doctorService.getDoctorById(doctor_id));
       patientService.addPatient(patient);
       return "home";
    }

    @GetMapping("/delete/patient")
    public String deletePatient(@RequestParam int id) {
        try {
            patientService.deletePatient(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @GetMapping("/getall/patient")
    public String getAllPatients() {
        patientService.getAllPatients();
        return "home";
    }
}
