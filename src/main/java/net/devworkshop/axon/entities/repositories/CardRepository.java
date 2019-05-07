package net.devworkshop.axon.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import net.devworkshop.axon.entities.CardQueryEntity;

public interface CardRepository extends CrudRepository<CardQueryEntity, String> {}