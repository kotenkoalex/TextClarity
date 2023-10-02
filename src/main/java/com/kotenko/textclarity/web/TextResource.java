package com.kotenko.textclarity.web;

import com.kotenko.textclarity.core.TextFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/text")
public class TextResource {

    private final TextFacade textFacade;

    public TextResource(TextFacade textFacade) {
        this.textFacade = textFacade;
    }

    @PostMapping
    public List<String> lemmatizeText(@RequestBody String text) {
        return textFacade.getLemmas(text);
    }
}
