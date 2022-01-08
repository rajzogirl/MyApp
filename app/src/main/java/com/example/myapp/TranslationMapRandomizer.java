package com.example.myapp;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class which contains method for extracting random words from provided translationMap
 *
 */
public class TranslationMapRandomizer {
    public final SecureRandom random = new SecureRandom();


    /**
     * Method used to extract random words from given translation map
     * @param translationMap - provided map of words to translate
     * @param n - count of elements to extract - if it is bigger than size of translationMap then
     *          is overwritten by translationMap.size()
     * @return HashMap containing N random words extracted from provided translation map
     */
    public HashMap<String, String> randomize (HashMap<String, String> translationMap, int n){
        HashMap<String, String> hashMap = new HashMap<>();

        if(n > translationMap.size()){
            n = translationMap.size();
        }
        Map.Entry<String, String>[] array = translationMap.entrySet().toArray(new Map.Entry[0]);
        List<Map.Entry<String, String>> list = new ArrayList<>(Arrays.asList(array));

        for (int i = n; i > 0; i--){
            int nextBound = (list.size() - 1) > 0 ? list.size() - 1: 1;
            int randomNumber = random.nextInt(nextBound);
            Map.Entry<String, String> randomEntry = list.get(randomNumber);
            hashMap.put(randomEntry.getKey(), randomEntry.getValue());
            list.remove(randomNumber);

        }

        return hashMap;
    }

}
