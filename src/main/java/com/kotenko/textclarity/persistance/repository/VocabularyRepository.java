package com.kotenko.textclarity.persistance.repository;

import com.kotenko.textclarity.persistance.entity.Vocabulary;
import org.springframework.data.repository.CrudRepository;

public interface VocabularyRepository extends CrudRepository<Vocabulary, Long> { }
