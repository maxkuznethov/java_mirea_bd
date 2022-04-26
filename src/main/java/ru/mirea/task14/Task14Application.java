package ru.mirea.task14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import ru.mirea.task14.services.DoctorService;
import ru.mirea.task14.components.Doctor;

@SpringBootApplication
@EnableScheduling
public class Task14Application {

    public static void main(String[] args) {
        SpringApplication.run(Task14Application.class, args);




}}
