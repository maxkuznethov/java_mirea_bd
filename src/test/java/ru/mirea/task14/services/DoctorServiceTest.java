package ru.mirea.task14.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mirea.task14.components.Doctor;
import ru.mirea.task14.repos.DoctorRep;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {
    @Mock
    private DoctorRep doctorRep;
    @Mock
    private EmailService emailService;
    @Captor
    ArgumentCaptor<Doctor> captor;


    @Test
    void getDoctors() {
        Doctor doctor = new Doctor("max", "kuznethov", "kab14");
        Doctor doctor2 = new Doctor("pavel", "saprykin", "kab7");
        Mockito.when(doctorRep.findAll()).thenReturn(List.of(doctor,doctor2));
        DoctorService doctorService= new DoctorService(doctorRep, emailService);
        Assertions.assertEquals(2, doctorService.getDoctors().size());
        Assertions.assertEquals("max",doctorService.getDoctors().get(0).getFirstName());
    }

    @Test
    void saveOrUpdate() {
        Doctor doctor = new Doctor("max", "kuznethov", "kab14");
        DoctorService doctorService= new DoctorService(doctorRep, emailService);
        doctorService.addDoctor(doctor);
        Mockito.verify(doctorRep).save(captor.capture());
        Doctor captured = captor.getValue();
        Assertions.assertEquals("max",captured.getFirstName());
    }
}
