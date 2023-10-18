package com.kotenko.textclarity.web;

import com.kotenko.textclarity.core.TextFacade;
import com.kotenko.textclarity.core.VocabularyModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/text")
@RequiredArgsConstructor
public class TextResource {

    private final TextFacade textFacade;

    @GetMapping("/{text}")
    public List<VocabularyModel> lemmatizeTextGet(@PathVariable String text) {
        return textFacade.preparedLemmas(text);
    }

    @PostMapping
    public List<VocabularyModel> lemmatizeTextPost(@RequestBody String text) {
        return textFacade.preparedLemmas(text);
    }
}
