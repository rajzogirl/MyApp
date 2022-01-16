package com.example.myapp;

import java.util.HashMap;

/**
 * Class with contains main, global state of application used to store current lesson object.
 * Every Activity has equal access to this class and it is data.
 * Implemented as a Singleton design pattern.
 */
public class ApplicationState {
        private static final int QUESTIONS_COUNT = 10;
        private static ApplicationState instance = null;

        private Lesson lesson = null;

        private final HashMap<String, String> polishToEnglishTranslationMap = new HashMap<String, String>(){{
            put ("good", "dobry");
            put ("red", "czerwony");
            put ("strong", "silny");
            put ("dog", "pies");
            put ("cat", "kot");
            put ("mirror", "lustro");
            put ("tree", "drzewo");
            put ("window", "okno");
            put ("person", "osoba");
            put ("bird", "ptak");
            put ("phone", "telefon");
            put ("blue", "niebieski");
            put ("green", "zielony");
            put ("purple", "fioletowy");
            put ("black", "czarny");
            put ("grey", "szary");
            put ("cow", "krowa");
            put ("mouse", "mysz");
            put ("fox", "lis");
            put ("owl", "sowa");
            put ("lion", "lew");
            put ("crocodile", "krokodyl");
            put ("duck", "kaczka");
            put ("sheep", "owca");
            put ("bat", "nietoperz");
            put ("shark", "rekin");
            put ("chicken", "kurczak");
            put ("grandmother", "babcia");
            put ("grandfather", "dziadek");
            put ("uncle", "wujek");
            put ("aunt", "ciocia");
            put ("father", "ojciec");
            put ("mother", "matka");
            put ("brother", "brat");
            put ("sister", "siostra");
            put ("son", "syn");
            put ("grandson", "wnuk");
            put ("juicy", "soczysty");
            put ("nice", "miły");
            put ("plant", "roślina");
            put ("name", "imie");
            put ("tomato", "pomidor");
            put ("sandwich", "kanapka");
            put ("smile", "uśmiech");
            put ("bike", "rower");
            put ("photo", "zdjęcie");
            put ("dress", "sukienka");
            put ("football", "piłka nożna");
            put ("basketball", "koszykówka");
            put ("daughter", "córka");
        }};

        private final HashMap<String, String> englishToPolishTranslationMap = new HashMap<String, String>(){{
            put ("sukienka", "dress");
            put ("dobry", "good");
            put ("kot", "cat");
            put ("kaczka", "duck");
            put ("pies", "dog");
            put ("lustro", "mirror");
            put ("drzewo", "tree");
            put ("okno", "window");
            put ("osoba", "person");
            put ("paznokcie", "nails");
            put ("palec", "finger");
            put ("noga", "leg");
            put ("skarpetki", "socks");
            put ("sok", "juice");
            put ("oko", "eye");
            put ("kolano", "knee");
            put ("syn", "son");
            put ("dziadek", "grandfather");
            put ("babcia", "grandmother");
            put ("ziemniak", "potato");
            put ("gwiazdy", "stars");
            put ("lato", "summer");
            put ("ryba", "fish");
            put ("makaron", "pasta");
            put ("mleko", "milk");
            put ("jajka", "eggs");
            put ("fabryka", "factory");
            put ("przystojny", "handsome");
            put ("nielegalny", "illegal");
            put ("cytryna", "lemon");
            put ("kwiaty", "flowers");
            put ("woda", "water");
            put ("lalka", "doll");
            put ("marchewka", "carrot");
            put ("winogrono", "grapes");
            put ("ser", "cheese");
            put ("chleb", "bread");
            put ("motyl", "butterfly");
            put ("uszy", "ears");
            put ("truskawka", "strawberry");
            put ("banan", "banana");
            put ("smok", "dragon");
            put ("kucharz", "chef");
            put ("klient", "customer");
            put ("nagroda", "award");
            put ("czosnek", "garlic");
            put ("cebula", "onion");
            put ("por", "leek");
            put ("lis", "fox");
            put ("tygrys", "tiger");
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
