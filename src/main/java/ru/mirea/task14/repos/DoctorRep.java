package ru.mirea.task14.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.task14.components.Doctor;

import java.util.List;

@Repository
public interface DoctorRep extends JpaRepository<Doctor, Integer> {
    Doctor findByFirstName(String firstName);

    Doctor findDoctorById(int id);

    List<Doctor> findAllByFirstName(String firstName);

    List<Doctor> findAllByLastName(String lastName);

    List<Doctor> findAllByPosition(String position);
}
