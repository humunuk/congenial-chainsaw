package com.example.lhvhomework.entities;

import com.example.lhvhomework.util.NoiseWordsRemover;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class SanctionedPersonEventHandler {

    @HandleBeforeCreate
    public void handleSanctionedPersonSave(SanctionedPerson person) {
        NoiseWordsRemover noiseWordsRemover = new NoiseWordsRemover();
        person.setName(noiseWordsRemover.removeNoiseWords(person.getName()));
    }
}
