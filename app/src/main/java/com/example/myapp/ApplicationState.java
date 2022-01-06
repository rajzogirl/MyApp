package com.example.myapp;

import java.util.HashMap;

public class ApplicationState {
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



        private ApplicationState() { }

        public static ApplicationState getInstance() {
            if (instance == null){
            instance = new ApplicationState();
        }
            return instance;
        }

        public void startNewLesson(LessonMode lessonMode){
            this.lessonMode = lessonMode;
                    if (lessonMode == LessonMode.POLISH_TO_ENGLISH){
                        lesson = new Lesson(polishToEnglishTranslationMap, 6);
                    }else if (lessonMode == LessonMode.ENGLISH_TO_POLISH){
                        lesson = new Lesson(englishToPolishTranslationMap, 6);
                    }
        }

        public Lesson getLesson() {
            return lesson;
        }

        public LessonMode getLessonMode(){
            return lessonMode;
        }

}
