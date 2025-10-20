package com.hafidelmoudden.microservices.keynoteservice;

import com.hafidelmoudden.microservices.keynoteservice.entities.Keynote;
import com.hafidelmoudden.microservices.keynoteservice.repositories.KeynoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KeynoteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeynoteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(KeynoteRepository keynoteRepository) {
        return args -> {
            keynoteRepository.save(Keynote.builder()
                    .nom("Elmoudden")
                    .prenom("Hafid")
                    .email("hafidelmoudden2003@gmail.com")
                    .fonction("Speaker").build());

            keynoteRepository.findAll().forEach(e -> {
                System.out.println("=============================");
                System.out.println("Nom: " + e.getNom());
                System.out.println("Prenom: " + e.getPrenom());
                System.out.println("Email: " + e.getEmail());
                System.out.println("Fonction: " + e.getFonction());
                System.out.println("============================");

            });
        };
    }
}
