package ru.mirea.task14.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Async
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    private static final String email= "maxkuznethov.springtest@gmail.com";

    public void sendSimpleMessage(
            String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
}