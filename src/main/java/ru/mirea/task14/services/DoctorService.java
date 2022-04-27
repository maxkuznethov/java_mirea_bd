package ru.mirea.task14.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.task14.components.Doctor;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.repos.DoctorRep;

import java.util.List;

@Service
@Slf4j
@Transactional
public class DoctorService {
    private final DoctorRep doctorRep;
    private final EmailService emailService;


    public DoctorService(DoctorRep doctorRep, EmailService emailService) {
        this.doctorRep = doctorRep;
        this.emailService = emailService;
    }


    public boolean addDoctor(Doctor doctor) {
        log.info("Save doctor {}", doctor);
        doctorRep.save(doctor);
        emailService.sendSimpleMessage("Doctors", String.format("Doctor added: %s", doctor));
        return true;
    }

    public boolean deleteDoctor(int id) {
        log.info("Delete doctor {}", doctorRep.findDoctorById(id));
        doctorRep.deleteById(id);
        return true;
    }

    public void printAllDoctors() {
        log.info("Print all doctors");
        List<Doctor> doctorList = getDoctors();
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }
    }

    public List<Doctor> getDoctors() {
        log.info("Get all doctors");
        return doctorRep.findAll();
    }

    public Doctor getDoctorById(int id) {
        log.info("Find doctor {}", doctorRep.findDoctorById(id));
        return doctorRep.findDoctorById(id);
    }

    public void getDoctorPatients(int id) {
        log.info("Find all doctor's patients");
        Doctor doctor = getDoctorById(id);
        List<Patient> patientList = doctor.getPatientList();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }

}
