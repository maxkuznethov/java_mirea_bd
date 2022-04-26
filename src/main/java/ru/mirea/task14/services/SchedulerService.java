package ru.mirea.task14.services;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.mirea.task14.components.Doctor;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.repos.DoctorRep;
import ru.mirea.task14.repos.PatientRep;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
@ManagedResource
public class SchedulerService {
    private final DoctorRep doctorRep;
    private final PatientRep patientRep;

    SchedulerService(DoctorRep doctorRep, PatientRep patientRep) {
        this.patientRep = patientRep;
        this.doctorRep = doctorRep;
    }

    @ManagedOperation
    @Scheduled(fixedDelay = 100000)
    public void scheduleFixedDelayTask() {
        try {
            FileUtils.cleanDirectory(new File("D:/java/task14/DB_log"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter doctorWriter = new FileWriter("D:/java/task14/DB_log/doctors.txt");
             FileWriter patientWriter = new FileWriter("D:/java/task14/DB_log/patients.txt")) {

            List<Doctor> doctorList = doctorRep.findAll();
            for(Doctor doctor: doctorList){
                doctorWriter.write(doctor+"\n");
            }

            List<Patient> patientList=patientRep.findAll();
            for (Patient patient: patientList){
                patientWriter.write(patient+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
