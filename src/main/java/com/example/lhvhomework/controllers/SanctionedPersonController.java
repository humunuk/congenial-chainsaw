package com.example.lhvhomework.controllers;

import ch.qos.logback.classic.Logger;
import com.example.lhvhomework.entities.SanctionedPerson;
import com.example.lhvhomework.repositories.SanctionedPersonRepository;
import com.example.lhvhomework.util.NoiseWordsRemover;
import me.xdrop.fuzzywuzzy.FuzzySearch;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;


@BasePathAwareController
public class SanctionedPersonController {

    private final SanctionedPersonRepository repository;
    private final EntityLinks entityLinks;
    private final Log logger = LogFactory.getLog(getClass());

    SanctionedPersonController(SanctionedPersonRepository repository, EntityLinks entityLinks) {
        this.repository = repository;
        this.entityLinks = entityLinks;
    }

    @GetMapping("/sanctioned/search")
    public ResponseEntity<?> findByName(@RequestParam String name) {

        SanctionedPerson person = null;
        NoiseWordsRemover noiseWordsRemover = new NoiseWordsRemover();

        Iterable<SanctionedPerson> persons = repository.findAll();

        name = noiseWordsRemover.removeNoiseWords(name);

        for (SanctionedPerson sanctionedPerson: persons) {
            int weightedScore = FuzzySearch.weightedRatio(sanctionedPerson.getName(), name);
            int ratio = FuzzySearch.ratio(sanctionedPerson.getName(), name);
            int partialRatio = FuzzySearch.partialRatio(sanctionedPerson.getName(), name);

            logger.info("weighted: " + weightedScore + " ratio: " + ratio + " partial: " + partialRatio);

            if (weightedScore > 90 || ratio > 90 || partialRatio > 90) {
                person = sanctionedPerson;
                break;
            }
        }

        if (person == null) {
            throw new ResourceNotFoundException("Person named: " + name + " not found");
        }


        EntityModel<SanctionedPerson> model = EntityModel.of(person)
                .add(entityLinks.linkToItemResource(SanctionedPerson.class, person.getId()).withSelfRel());

        return ResponseEntity.ok(model);
    }

    @DeleteMapping("/sanctioned/{id}")
    public void deletePerson(@PathVariable Long id) {
        SanctionedPerson person = repository.findById(id).orElseThrow(ResourceNotFoundException::new);
        person.setDeletedAt(new Timestamp(new Date().getTime()));

        repository.save(person);
    }
}
