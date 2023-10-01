package com.example.lhvhomework;

import com.example.lhvhomework.controllers.SanctionedPersonController;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;


@Component
public class LinkProcessor implements RepresentationModelProcessor<RepositoryLinksResource> {
    @Override
    public RepositoryLinksResource process(RepositoryLinksResource model) {
        model.add(Link.of("/sanctioned/search?name=").withRel("search"));
        return model;
    }
}
