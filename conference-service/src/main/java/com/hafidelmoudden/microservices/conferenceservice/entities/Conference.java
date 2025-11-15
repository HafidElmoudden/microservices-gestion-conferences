package com.hafidelmoudden.microservices.conferenceservice.entities;

import com.hafidelmoudden.microservices.conferenceservice.models.Keynote;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;


@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Conference {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    @Enumerated(EnumType.STRING)
    private TypeConference type;
    private LocalDateTime date;
    private int dureeMinutes;
    private long nbrInscrits;
    private double score;
    private long keynoteId;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    @Transient
    private Keynote keynote;
}
