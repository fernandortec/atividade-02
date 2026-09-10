package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.exception.SendEmailException;

@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String body) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            message.setFrom("mrfox2344@gmail.com");

            mailSender.send(message);
        } catch (Exception e) {
            throw new SendEmailException("Falha ao enviar e-mail: " + e.getMessage());
        }
    }
}
