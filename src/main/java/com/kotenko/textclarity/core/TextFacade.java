package com.kotenko.textclarity.core;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Properties;
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

    public List<String> getLemmas(String text) {
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
