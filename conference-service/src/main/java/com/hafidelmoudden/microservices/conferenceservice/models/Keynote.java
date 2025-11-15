package com.hafidelmoudden.microservices.conferenceservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Keynote {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String fonction;
}
