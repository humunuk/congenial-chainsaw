package com.example.lhvhomework.util;


import org.apache.commons.lang3.StringUtils;

public class NoiseWordsRemover {

    private final String[] noiseWords = {"the", "to", "an", "mrs", "mr",
            "and", "miss", "dr"};

    public String removeNoiseWords(String name) {

        name = name.toLowerCase();

        for (String noiseWord: noiseWords) {
            name = name.replaceAll(noiseWord, "");
        }

        return StringUtils.capitalize(name);
    }

}
