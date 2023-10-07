package com.kotenko.textclarity.persistance;

import jakarta.persistence.*;

@Entity
@Table(name = "vocabulary")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String word;

    public Vocabulary() {
    }

    public Vocabulary(Long id, String word) {
        this.id = id;
        this.word = word;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", word='" + word + '\'' +
                '}';
    }
}
