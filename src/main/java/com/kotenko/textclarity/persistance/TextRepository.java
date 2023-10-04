package com.kotenko.textclarity.persistance;

import com.kotenko.textclarity.core.TextAdapter;
import org.springframework.stereotype.Service;

@Service
public class TextRepository implements TextAdapter {
    @Override
    public String firstFun() {
        return "it works";
    }
}
