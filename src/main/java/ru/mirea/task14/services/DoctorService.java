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

    @Autowired
    public DoctorService(DoctorRep doctorRep) {
        this.doctorRep = doctorRep;
    }


    public boolean addDoctor(Doctor doctor) {
        log.info("Save doctor {}", doctor);
        doctorRep.save(doctor);
        return true;
    }

    public boolean deleteDoctor(int id) {
        log.info("Delete doctor {}", doctorRep.findDoctorById(id));
        doctorRep.deleteById(id);
        return true;
    }

    public void getAllDoctors() {
        log.info("Find all doctors");
        List<Doctor> doctorList = doctorRep.findAll();
        for (Doctor doctor : doctorList) {
            System.out.println(doctor);
        }

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
