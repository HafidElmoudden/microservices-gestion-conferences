package com.hafidelmoudden.microservices.conferenceservice;

import com.hafidelmoudden.microservices.conferenceservice.entities.Conference;
import com.hafidelmoudden.microservices.conferenceservice.entities.Review;
import com.hafidelmoudden.microservices.conferenceservice.entities.TypeConference;
import com.hafidelmoudden.microservices.conferenceservice.repositories.ConferenceRepository;
import com.hafidelmoudden.microservices.conferenceservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class ConferenceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConferenceServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ConferenceRepository conferenceRepository, ReviewRepository reviewRepository) {
		return args -> {
			Conference conf1 = new Conference();
			conf1.setTitre("Spring Boot Deep Dive");
			conf1.setType(TypeConference.ACADEMIQUE);
			conf1.setDate(LocalDateTime.now().plusDays(10));
			conf1.setDureeMinutes(90);
			conf1.setNbrInscrits(120);
			conf1.setScore(4.5);
			conf1.setKeynoteId(1L);

			conferenceRepository.save(conf1);

			Review r1 = new Review();
			r1.setTexte("Excellent session!");
			r1.setStars(5);
			r1.setConference(conf1);

			Review r2 = new Review();
			r2.setTexte("Too long but informative.");
			r2.setStars(4);
			r2.setConference(conf1);

			reviewRepository.saveAll(List.of(r1, r2));

			conferenceRepository.findAll().forEach(conf -> {
				System.out.println("Conference: " + conf.getTitre());
				conf.getReviews().forEach(review -> {
					System.out.println("  Review: " + review.getTexte() + " (" + review.getStars() + " stars)");
				});
			});
		};
	}
}
