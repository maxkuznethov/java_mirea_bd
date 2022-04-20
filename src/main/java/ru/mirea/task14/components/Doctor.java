package ru.mirea.task14.components;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patientList;

    public Doctor(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public Doctor() {
    }


    @Override
    public String toString() {
        return firstName + " " + lastName + ", " + position;
    }
}
