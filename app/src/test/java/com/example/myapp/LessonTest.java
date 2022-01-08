package com.example.myapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class LessonTest {

    private Lesson lesson;

    private final HashMap<String, String> testTranslationMap = new HashMap<String, String>(){{
        put ("good", "dobry");
    }};


    @Before
   public void setUp(){
        lesson = new Lesson(testTranslationMap);
    }

    @Test
    public void testCheckWord() {
        String word = lesson.getNextWordToTranslate();
        String[] keys = testTranslationMap.keySet().toArray(new String[0]);
        String translated = keys[0];
        assertTrue(lesson.checkWord(translated));
        assertFalse(lesson.checkWord("Wrong answer"));
    }

    @Test
    public void testIsOver() {
        assertFalse(lesson.isOver());
        lesson.checkWord("Wrong answer");
        assertTrue(lesson.isOver());
    }
}