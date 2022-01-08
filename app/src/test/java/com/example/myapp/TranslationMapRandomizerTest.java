package com.example.myapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class TranslationMapRandomizerTest {
    TranslationMapRandomizer randomizer;

    private final HashMap<String, String> testTranslationMap = new HashMap<String, String>(){{
        put ("good", "dobry");
        put ("nice", "miły");
        put ("strong", "silny");
        put ("dog", "pies");
        put ("cat", "kot");
        put ("mirror", "lustro");
        put ("tree", "drzewo");
        put ("window", "okno");
        put ("person", "osoba");
        put ("bird", "ptak");
        put ("phone", "telefon");
    }};

    @Before
    public void setUp() {
        randomizer = new TranslationMapRandomizer();
    }

    @Test
    public void testRandomize() {
        HashMap<String, String> mapWithCount3 = randomizer.randomize(testTranslationMap, 3);
        assertEquals(mapWithCount3.size(), 3);

        HashMap<String, String> mapWithCountBiggerThanSize = randomizer.randomize(testTranslationMap, 1000);
        assertEquals(mapWithCountBiggerThanSize.size(), testTranslationMap.size());
    }
}