package com.kotenko.textclarity.persistance;

import com.kotenko.textclarity.core.TextAdapter;
import com.kotenko.textclarity.persistance.repository.VocabularyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextRepository implements TextAdapter {

    private final VocabularyRepository vocabularyRepository;

    public TextRepository(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    @Override
    public List<Vocabulary> findAll() {
        return (List<Vocabulary>)vocabularyRepository.findAll();
    }
}
