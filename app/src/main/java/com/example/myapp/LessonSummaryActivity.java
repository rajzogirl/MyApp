package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * Activity displayed at the end of the lesson
 * Displays score, "motivational quote" based on score and provides
 * ability to start lesson in the same mode as previous or navigate to MainActivity.
 */
public class LessonSummaryActivity extends AppCompatActivity {

    /**
     * This lesson displays user score and "motivational quote" based on that score
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_summary);
        TextView finalScoreTextView = findViewById(R.id.points);
        TextView scoreMessageTextView = findViewById(R.id.score_message);

        ApplicationState appState = ApplicationState.getInstance();
        Lesson lesson = appState.getLesson();

        int correctAnswerCount = lesson.getCorrectAnswerCount();
        int wordsCount = lesson.getWordsCount();

        String score = String.format(Locale.ROOT, "%d/%d", correctAnswerCount, wordsCount);
        finalScoreTextView.setText(score);

        float scoreFactor = (float)correctAnswerCount / (float)wordsCount;
        String scoreMessage;

        if (scoreFactor> 0.7f){
            scoreMessage = getString(R.string.score_message_awesome);
        }
        else if (scoreFactor> 0.4f){
            scoreMessage = getString(R.string.score_message_good);
        }
        else {
            scoreMessage = getString(R.string.score_message_bad);
        }

        scoreMessageTextView.setText(scoreMessage);
    }

    /**
     * Function called when start Again button is clicked
     * It starts new lesson with the same mode as previous and navigates to QuestionActivity
     * @param view
     */
    public void onClickStartAgain (View view) {
        ApplicationState appState = ApplicationState.getInstance();
        ApplicationState.LessonMode lessonMode = appState.getLessonMode();
        appState.startNewLesson(lessonMode);
        Intent intent = new Intent (this, QuestionActivity.class);
        startActivity(intent);
        finish();

    }

    /**
     * Function call when Exit button is clicked
     * Navigates to MainActivity
     * @param view
     */
    public void onClickExit (View view) {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
        finish();

    }
}