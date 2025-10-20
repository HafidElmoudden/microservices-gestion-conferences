package com.hafidelmoudden.microservices.conferenceservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private String texte;
    @Min(1) @Max(5)
    private int stars;

    @ManyToOne(fetch = FetchType.LAZY)
    Conference conference;
}
