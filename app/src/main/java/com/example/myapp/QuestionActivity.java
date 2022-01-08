package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

/**
 * Activity which displays question to translate and provides text input for user
 * to enter translated word.
 * Also provides Submit button to check if answer was correct.
 */
public class QuestionActivity extends AppCompatActivity {
    TextView scoreTextView = null;
    TextView questionTitle = null;
    TextView wordToTranslate = null;

    /**
     * Display word to translate if lesson is not over.
     * If is over, then navigate to LessonSummaryActivity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        scoreTextView = findViewById(R.id.score);
        questionTitle = findViewById(R.id.question_title);
        wordToTranslate = findViewById(R.id.word_to_translate);

        ApplicationState appState = ApplicationState.getInstance();
        Lesson lesson = appState.getLesson();

        if (!lesson.isOver()){
            int currentWordNumber = lesson.getCurrentWordNumber() + 1;
            int wordsCount = lesson.getWordsCount();

            String score = String.format(Locale.ROOT,"%d/%d", currentWordNumber, wordsCount);
            scoreTextView.setText(score);
            ApplicationState.LessonMode lessonMode =  appState.getLessonMode();

            String questionTitleString = "";
            if(lessonMode == ApplicationState.LessonMode.ENGLISH_TO_POLISH){
                questionTitleString = getString(R.string.translate_following_word_to_polish);
            }else if (lessonMode == ApplicationState.LessonMode.POLISH_TO_ENGLISH){
                questionTitleString = getString(R.string.translate_following_word_to_english);
            }

            questionTitle.setText(questionTitleString);
            wordToTranslate.setText(lesson.getNextWordToTranslate());
        }
        else{
            Intent intent = new Intent(this, LessonSummaryActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * Function called when submit button is clicked.
     * Check if answer provided in user_input is correct
     * If so, navigate to CorrectAnswerActivity
     * If not, navigate to WrongAnswerActivity
     * @param view
     */
    public void onClickSubmit(View view) {
        ApplicationState appState = ApplicationState.getInstance();
        Lesson lesson = appState.getLesson();
        TextView userInput = findViewById(R.id.user_input);
        String wordFromUser = userInput.getText().toString();

        boolean result = lesson.checkWord(wordFromUser);

        Intent intent;

        if (result) {
            intent = new Intent(this, CorrectAnswerActivity.class);
        } else {
            intent = new Intent(this, WrongAnswerActivity.class);
        }
        startActivity(intent);
        finish();
    }
}