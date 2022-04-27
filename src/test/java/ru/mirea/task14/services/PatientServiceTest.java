package ru.mirea.task14.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task14.components.Patient;
import ru.mirea.task14.repos.PatientRep;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {
    @Mock
    private PatientRep patientRep;
    @Mock
    private EmailService emailService;
    @Captor
    ArgumentCaptor<Patient> captor;


    @Test
    void getPatients() {
        Patient patient = new Patient();
        Patient patient2 = new Patient();
        patient.setFirstName("andrew");
        patient2.setFirstName("alyona");

        Mockito.when(patientRep.findAll()).thenReturn(List.of(patient,patient2));
        PatientService patientService= new PatientService(patientRep, emailService);
        Assertions.assertEquals(2, patientService.getPatients().size());
        Assertions.assertEquals("alyona",patientService.getPatients().get(1).getFirstName());
    }

    @Test
    void saveOrUpdate() {
        Patient patient =new Patient();
        patient.setFirstName("viktor");
        PatientService patientService =new PatientService(patientRep,emailService);
        patientService.addPatient(patient);
        Mockito.verify(patientRep).save(captor.capture());
        Patient captured = captor.getValue();
        Assertions.assertEquals("viktor",captured.getFirstName());
    }
}
