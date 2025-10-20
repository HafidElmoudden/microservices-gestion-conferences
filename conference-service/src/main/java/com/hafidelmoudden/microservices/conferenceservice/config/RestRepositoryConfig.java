package com.hafidelmoudden.microservices.conferenceservice.config;

import com.hafidelmoudden.microservices.conferenceservice.entities.Conference;
import com.hafidelmoudden.microservices.conferenceservice.entities.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Conference.class);
        config.exposeIdsFor(Review.class);
    }
}
