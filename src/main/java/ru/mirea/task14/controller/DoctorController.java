package ru.mirea.task14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mirea.task14.components.Doctor;
import ru.mirea.task14.services.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/add")
    public String addDoctor(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String position) {
        Doctor doctor = new Doctor(firstName, lastName, position);
        doctorService.addDoctor(doctor);
        return "home";
    }

    @GetMapping("/delete")
    public String deleteDoctor(@RequestParam int id) {
        try {
            doctorService.deleteDoctor(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "home";
    }

    @GetMapping("/getall")
    public String getAllDoctors() {
        doctorService.printAllDoctors();
        return "home";
    }

    @GetMapping("/getpatients")
    public String getDoctor(@RequestParam int id){
        doctorService.getDoctorPatients(id);
        return "home";
    }
}
