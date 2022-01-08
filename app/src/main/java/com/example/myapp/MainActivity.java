package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Application entry point
 * Displays two buttons which each is different lesson mode
 * First is translating from english to polish and
 * second is translating from polish to english.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Function called when Polish To English button is clicked
     * start new lesson with polish to english mode and navigate to QuestionActivity
     * @param view
     */
    public void onClickPolishToEnglish(View view) {
        ApplicationState applicationState = ApplicationState.getInstance();
        applicationState.startNewLesson(ApplicationState.LessonMode.POLISH_TO_ENGLISH);

        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    /**
     * Function called when English to Polish button is clicked
     * start new lesson with english to polish mode and navigate to QuestionActivity
     * @param view
     */
    public void onClickEnglishToPolish(View view) {
        ApplicationState applicationState = ApplicationState.getInstance();
        applicationState.startNewLesson(ApplicationState.LessonMode.ENGLISH_TO_POLISH);

        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }



}

