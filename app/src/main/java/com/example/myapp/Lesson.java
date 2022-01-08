package com.example.myapp;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

/**
 * Main class which contains logic for providing words to translate
 * and checking translated words from user
 */
public class Lesson {

    int wordsCount;
    int correctAnswerCount = 0;
    int currentWordNumber = 0;
    String[] wordsToTranslate;
    HashMap<String, String> translationMap;
    private final SecureRandom random = new SecureRandom();


    /**
     * lesson class constructor
     * @param translationMap map which contains words to translate in format
     *                       : {"word which user provides" : "word which is displayed"}
     */
    public Lesson(HashMap<String, String> translationMap){
        this.translationMap = translationMap;
        wordsToTranslate = this.translationMap.values().toArray(new String[0]);
        this.wordsCount = wordsToTranslate.length;
    }

    /**
     * Method that checks if user provided correct translation
     * @param word translation for current word, provided by user in QuestionActivity's text input
     * @return true if translation provided by user is correct, false if not
     */
    public boolean checkWord(String word) {
        String wordLowerCase = word.toLowerCase(Locale.ROOT);
                boolean result = false;
        if (translationMap.containsKey(wordLowerCase)){
            correctAnswerCount++;
            result = true;
        }
        currentWordNumber++;
        return result;
    }

    /**
     * @return true if currentWordNumber is  equal to wordsCount which
     * means that lesson is over
     */
    public boolean isOver(){
        return currentWordNumber == wordsCount;
    }

    public String getNextWordToTranslate(){
        return wordsToTranslate[currentWordNumber];
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public int getCorrectAnswerCount() {
        return  correctAnswerCount;
    }

    public int getCurrentWordNumber() {
        return currentWordNumber;
    }

}
