package com.example.myapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Lesson {

    int wordsCount;
    int correctAnswerCount = 0;
    int currentWordNumber = 0;
    String[] wordsToTranslate;
    HashMap<String, String> translationMap;

    private HashMap<String, String> getNRandomWords(HashMap<String, String> translationMap, int count){
        HashMap<String, String> hashMap = new HashMap<>();
        Random random = new Random(System.currentTimeMillis());

        if(count > translationMap.size()){
            count = translationMap.size();
        }
        Map.Entry<String, String>[] array = translationMap.entrySet().toArray(new Map.Entry[0]);
        List<Map.Entry<String, String>> list = new ArrayList<>(Arrays.asList(array));

        for (int i = count; i > 0; i--){
            int randomNumber = random.nextInt(count);
            Map.Entry<String, String> randomEntry = list.get(randomNumber);
            hashMap.put(randomEntry.getKey(), randomEntry.getValue());
            list.remove(randomNumber);

        }

        return hashMap;
    }

    public Lesson(HashMap<String, String> translationMap, int wordsCount){
        this.translationMap = getNRandomWords(translationMap, wordsCount);
        wordsToTranslate = this.translationMap.values().toArray(new String[0]);
        this.wordsCount = wordsToTranslate.length;
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
