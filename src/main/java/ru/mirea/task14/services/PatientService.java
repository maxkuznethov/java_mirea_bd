package ru.mirea.task14.services;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.repos.PatientRep;

import java.util.List;

@Service
@Getter
@Setter
@Slf4j
public class PatientService {
    @Autowired
    private PatientRep patientRep;


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
