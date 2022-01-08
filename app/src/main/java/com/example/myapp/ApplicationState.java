package com.example.myapp;

import java.util.HashMap;

/**
 * Class with constains main, global state of application used to store current lesson object.
 * Every Activity has equal access to this class and it is data.
 * Implemented as a Singleton design pattern.
 */
public class ApplicationState {
        private static final int QUESTIONS_COUNT = 10;
        private static ApplicationState instance = null;

        private Lesson lesson = null;

        private final HashMap<String, String> polishToEnglishTranslationMap = new HashMap<String, String>(){{
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

        private final HashMap<String, String> englishToPolishTranslationMap = new HashMap<String, String>(){{
            put ("ciekawy", "interesting");
            put ("dobry", "good");
        }};


        public enum LessonMode {
            ENGLISH_TO_POLISH,
            POLISH_TO_ENGLISH
        }
        private LessonMode lessonMode;


    /**
     * Private ApplicationState constructor
     */
    private ApplicationState() { }


    /**
     * Returns instance of ApplicationState singleton and creates new ApplicationState object
     * when instance equals null
     * @return ApplicationState singleton instance
     */
        public static ApplicationState getInstance() {
            if (instance == null){
            instance = new ApplicationState();
        }
            return instance;
        }

    /**
     * Creates new lesson object with randomized translation map in given mode
     * @param lessonMode mode of created lesson provided by user in MainActivity
     */
        public void startNewLesson(LessonMode lessonMode){
            this.lessonMode = lessonMode;
            TranslationMapRandomizer randomizer = new TranslationMapRandomizer();
                    if (lessonMode == LessonMode.POLISH_TO_ENGLISH){
                        lesson = new Lesson(randomizer.randomize(polishToEnglishTranslationMap, QUESTIONS_COUNT));
                    }else if (lessonMode == LessonMode.ENGLISH_TO_POLISH){
                        lesson = new Lesson(randomizer.randomize(englishToPolishTranslationMap, QUESTIONS_COUNT));
                    }
        }

        public Lesson getLesson() {
            return lesson;
        }

        public LessonMode getLessonMode(){
            return lessonMode;
        }

}
