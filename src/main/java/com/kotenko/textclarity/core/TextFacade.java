package com.kotenko.textclarity.core;

import com.kotenko.textclarity.persistance.Vocabulary;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TextFacade {
    private final TextAdapter textAdapter;
    private static final StanfordCoreNLP pipeline = getStanfordCoreNLP();

    private static StanfordCoreNLP getStanfordCoreNLP() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        return new StanfordCoreNLP(props);
    }

    public TextFacade(TextAdapter textAdapter) {
        this.textAdapter = textAdapter;
    }

    public List<WordModel> preparedLemmas(String text) {
        List<String> words = textAdapter.findAll().stream()
                .map(Vocabulary::getWord)
                .toList();
        //filtered lemmas based on db data
        return getLemmas(text).stream()
                .filter(lemma -> !words.contains(lemma))
                .map(WordModel::new)
                .collect(Collectors.toList());
    }

    private List<String> getLemmas(String text) {
        //split to separate words
        List<String> words = Arrays.stream(text
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z-]", " ")
                        .split("\\s+"))
                .map(String::trim)
                .distinct()
                .toList();
        //convert separate words to lemmas
        List<CoreDocument> documents = words.stream().map(CoreDocument::new).toList();
        documents.parallelStream().forEach(pipeline::annotate);
        return documents.parallelStream()
                .flatMap(doc -> doc.tokens().parallelStream())
                .map(CoreLabel::lemma)
                .filter(word -> word.length() > 1)
                .distinct()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}


