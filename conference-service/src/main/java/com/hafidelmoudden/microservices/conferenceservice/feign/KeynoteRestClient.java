package com.hafidelmoudden.microservices.conferenceservice.feign;

import com.hafidelmoudden.microservices.conferenceservice.models.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable("id") long id);

    @GetMapping("/keynotes")
    PagedModel<Keynote> getAllKeynotes();
}
