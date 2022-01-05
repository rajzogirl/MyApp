package com.example.myapp;

public class ApplicationState {
        private static ApplicationState instance = null;

        private Lesson lesson = null;

        private ApplicationState() { }

        public static ApplicationState getInstance() {
            if (instance == null){
            instance = new ApplicationState();
        }
            return instance;
        }

        public void startNewLesson(){
            lesson = new Lesson();
        }

        public Lesson getLesson() {
            return lesson;
        }

}
