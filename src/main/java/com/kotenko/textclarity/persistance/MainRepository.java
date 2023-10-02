package com.kotenko.textclarity.persistance;

import com.kotenko.textclarity.core.MainAdapter;
import org.springframework.stereotype.Service;

@Service
public class MainRepository implements MainAdapter {
    @Override
    public String firstFun() {
        return "it works";
    }
}
