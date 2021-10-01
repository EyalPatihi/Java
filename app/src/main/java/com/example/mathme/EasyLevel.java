package com.example.mathme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class EasyLevel extends AppCompatActivity implements View.OnClickListener {

    private Button falseButton;
    private Button trueButton;
    private int correct = 0;
    private int score = 0;
    private int currentQuestionIndex = 0;
    private TextView question;
    private TextView scoreText;
    Random rand = new Random();
    private Question[] questionBank = new Question[] {
            // Array of objects of class Question
            // providing questions from string
            // resource and the correct answer
            new Question(R.string.question1, false),
            new Question(R.string.question2, true),
            new Question(R.string.question3, false),
            new Question(R.string.question4, false),
            new Question(R.string.question5, true),
            new Question(R.string.question6, false),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);
        //RandQuestion();

        trueButton = findViewById(R.id.trueBtn);
        trueButton.setOnClickListener(this);

        falseButton = findViewById(R.id.falseBtn);
        falseButton.setOnClickListener(this);

        scoreText = findViewById(R.id.scoreEditText);

        question = findViewById(R.id.quesTextView);
        question.setText(R.string.question2);
    }

    @Override
    public void onClick(View view) {
        if(view == trueButton)
            checkAnswer(true);

        if(view == falseButton)
            checkAnswer(false);
    }

    private void checkAnswer(boolean userChooseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        // Getting correct answer of current question
        int toastMessageId;
        // If answer matches with the clicked button

        if (userChooseCorrect == answerIsTrue) {
            correct++;
            score = correct * 5;
            scoreText.setText(score);
            toastMessageId = R.string.correct_answer;
            //RandQuestion();
        }
        else {
            // Showing toast: message correct
            toastMessageId = R.string.wrong_answer;
            //RandQuestion();
        }

        Toast.makeText(this, toastMessageId, Toast.LENGTH_SHORT).show();
    }

    /*@SuppressLint("SetTextI18n")
    private void RandQuestion(){
        //int randQuesNum = rand.nextInt(5);
        question.setText(R.string.question1);
    }*/
}
