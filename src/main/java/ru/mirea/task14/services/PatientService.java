package ru.mirea.task14.services;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.repos.PatientRep;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PatientService {
    private final PatientRep patientRep;

    @Autowired
    public PatientService(PatientRep patientRep) {
        this.patientRep = patientRep;
    }


    public boolean addPatient(Patient patient) {
        log.info("Save patient {}", patient);
        patientRep.save(patient);
        return true;
    }

    public boolean deletePatient(int id) {
        log.info("Delete patient {}", patientRep.findById(id));
        patientRep.deleteById(id);
        return true;
    }

    public void getAllPatients() {
        log.info("Find all patients");
        List<Patient> patientList = patientRep.findAll();
        for (Patient patient : patientList) {
            System.out.println(patient);
        }
    }
}
