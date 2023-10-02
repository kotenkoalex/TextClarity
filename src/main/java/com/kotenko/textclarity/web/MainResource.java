package com.kotenko.textclarity.web;

import com.kotenko.textclarity.core.MainFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/text")
public class MainResource {

    private final MainFacade mainFacade;

    public MainResource(MainFacade mainFacade) {
        this.mainFacade = mainFacade;
    }

    @GetMapping
    public String firstFun() {
        return mainFacade.firstFun();
    }
}
