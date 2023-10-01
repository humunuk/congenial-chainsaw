package com.example.lhvhomework.repositories;

import com.example.lhvhomework.entities.SanctionedPerson;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "sanctioned", path = "sanctioned")
public interface SanctionedPersonRepository extends PagingAndSortingRepository<SanctionedPerson, Long>, CrudRepository<SanctionedPerson, Long> {
    @Override
    @RestResource(exported = false)
    void delete(@NotNull SanctionedPerson entity);
}
