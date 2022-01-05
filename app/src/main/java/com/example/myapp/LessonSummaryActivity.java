package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class LessonSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_summary);
        TextView finalScoreTextView = findViewById(R.id.points);
        TextView scoreMessageTextView = findViewById(R.id.score_message);

        ApplicationState appState = ApplicationState.getInstance();
        Lesson lesson = appState.getLesson();

        int correctAnswerdCount = lesson.getCorrectAnswerCount();
        int wordsCount = lesson.getWordsCount();

        String score = String.format(Locale.ROOT, "%d/%d", correctAnswerdCount, wordsCount);
        finalScoreTextView.setText(score);

        float scoreFactor = correctAnswerdCount / wordsCount;
        String scoreMessage = "";

        if (scoreFactor> 0.7f){
            scoreMessage = getString(R.string.score_message_awesome);
        }
        else if(scoreFactor> 0.4f){
            scoreMessage = getString(R.string.score_message_good);
        }
        else {
            scoreMessage = getString(R.string.score_message_bad);
        }

        scoreMessageTextView.setText(scoreMessage);
    }
    public void onClickStartAgain (View view) {
        ApplicationState appState = ApplicationState.getInstance();
        appState.startNewLesson();
        Intent intent = new Intent (this, QuestionActivity.class);
        startActivity(intent);
        finish();

    }
    public void onClickExit (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}