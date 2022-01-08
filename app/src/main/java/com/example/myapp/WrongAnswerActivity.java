package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Displays when user provides incorrect answer.
 */
public class WrongAnswerActivity extends AppCompatActivity {


    /**
     * Displays current question number and questions count in top right corner
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong_answer);
        TextView scoreTextView = findViewById(R.id.score_wrong_answer);

        ApplicationState appState = ApplicationState.getInstance();
        Lesson lesson = appState.getLesson();

        int currentWordNumber = lesson.getCurrentWordNumber();
        int wordsCount = lesson.getWordsCount();

        String score = String.format(Locale.ROOT, "%d/%d", currentWordNumber, wordsCount);

        scoreTextView.setText(score);
    }

    /**
     * Navigate back to questionActivity
     * @param view
     */
    public void onClickNext(View view) {
        Intent intent = NavUtils.getParentActivityIntent(this);
        startActivity(intent);

    }
}