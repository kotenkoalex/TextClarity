package com.kotenko.textclarity.core;

import org.springframework.stereotype.Component;

@Component
public class MainFacade {

    private final MainAdapter mainAdapter;

    public MainFacade(MainAdapter mainAdapter) {
        this.mainAdapter = mainAdapter;
    }


    public String firstFun(){
        return mainAdapter.firstFun();
    }
}
