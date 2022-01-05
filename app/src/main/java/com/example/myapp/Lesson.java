package com.example.myapp;

import java.util.HashMap;
import java.util.Locale;

public class Lesson {
    HashMap<String, String> translationMap = new HashMap<String, String>() {{
        put ("good", "dobry");
        put ("nice", "miły");

    }};

    int wordsCount = 0;
    int correctAnswerCount = 0;
    int currentWordNumber = 0;

    String[] wordsToTranslate;

    public Lesson(){
        wordsToTranslate = translationMap.values().toArray(new String[0]);
        wordsCount = wordsToTranslate.length;
    }

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
