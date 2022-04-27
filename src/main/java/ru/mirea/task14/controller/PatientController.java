package ru.mirea.task14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.services.DoctorService;
import ru.mirea.task14.services.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private final PatientService patientService;
    private final DoctorService doctorService;

    public PatientController(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService= doctorService;
    }
    @GetMapping("/add")
    public String addPatient(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int doctor_id) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setDoctor(doctorService.getDoctorById(doctor_id));
        patientService.addPatient(patient);
        return "home";
    }

    @GetMapping("/delete")
    public String deletePatient(@RequestParam int id) {
        try {
            patientService.deletePatient(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @GetMapping("/getall")
    public String getAllPatients() {
        patientService.printAllPatients();
        return "home";
    }
}
