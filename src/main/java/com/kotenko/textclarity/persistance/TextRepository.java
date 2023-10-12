package com.kotenko.textclarity.persistance;

import com.kotenko.textclarity.core.TextAdapter;
import com.kotenko.textclarity.persistance.entity.Vocabulary;
import com.kotenko.textclarity.persistance.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TextRepository implements TextAdapter {

    private final VocabularyRepository vocabularyRepository;

    @Override
    public List<Vocabulary> findAll() {
        return (List<Vocabulary>)vocabularyRepository.findAll();
    }
}
