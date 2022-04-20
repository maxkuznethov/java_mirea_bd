package ru.mirea.task14.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "patients")
@AllArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    private Doctor doctor;

    public Patient() {
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
