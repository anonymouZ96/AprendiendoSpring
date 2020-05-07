package com.primerproyectospring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class App {

    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
        Saludator saludator;
        EmailService emailService;

        // saludator = appContext.getBean(Saludator.class); // Por tipo
        saludator = (Saludator) appContext.getBean("saludator"); // Por ID
        // saludator = appContext.getBean("saludator", Saludator.class); // Por ID y tipo

        emailService = appContext.getBean(EmailService.class); // Por tipo
        // emailService = (Saludator) appContext.getBean("emailService"); // Por ID
        // emailService = appContext.getBean("emailService", EmailService.class); // Por ID y tipo

        System.out.println(saludator.saludo());
        System.out.println("-------------------------------");
        emailService.enviarEmailSaludo("fer@gmail.com");

        ((ClassPathXmlApplicationContext) appContext).close();
    }
}

