package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickPolishToEnglish(View view) {
        ApplicationState applicationState = ApplicationState.getInstance();
        applicationState.startNewLesson(ApplicationState.LessonMode.POLISH_TO_ENGLISH);

        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    public void onClickEnglishToPolish(View view) {
        ApplicationState applicationState = ApplicationState.getInstance();
        applicationState.startNewLesson(ApplicationState.LessonMode.ENGLISH_TO_POLISH);

        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }



}

