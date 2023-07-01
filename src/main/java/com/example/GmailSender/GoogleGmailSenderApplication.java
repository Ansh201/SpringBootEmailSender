package com.example.GmailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class GoogleGmailSenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleGmailSenderApplication.class, args);
    }

    @Component
    static class MailSender {

        private final JavaMailSender javaMailSender;

        public MailSender(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }

        @EventListener(ApplicationReadyEvent.class)
        public void triggerMail() throws MessagingException {
            EmailSenderService senderService = new EmailSenderService(javaMailSender);
            senderService.sendSimpleEmail("gopalgangwar2001@gmail.com",
                    "This is the email subject",
                    "This is the email body");
        }
    }
}


