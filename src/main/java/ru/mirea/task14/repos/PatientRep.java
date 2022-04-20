package ru.mirea.task14.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.task14.components.Patient;

import java.util.List;

@Repository
public interface PatientRep extends JpaRepository<Patient, Integer> {
    Patient findByFirstName(String firstName);

    Patient findById(int id);


    List<Patient> findAllByFirstName(String firstName);

    List<Patient> findAllByLastName(String lastName);
}
