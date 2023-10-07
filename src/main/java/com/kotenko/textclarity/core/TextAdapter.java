package com.kotenko.textclarity.core;

import com.kotenko.textclarity.persistance.Vocabulary;

import java.util.List;

public interface TextAdapter {
    List<Vocabulary> findAll();
}
