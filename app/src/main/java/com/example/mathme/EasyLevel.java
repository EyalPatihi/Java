package com.example.mathme;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class EasyLevel extends AppCompatActivity implements View.OnClickListener {

    public Question currentQues;
    private Button falseButton;
    private Button trueButton;
    private String sum;
    private int score = 0;
    private TextView question;
    private TextView scoreText;
    Random rand = new Random();
    private final Question[] questionBank = new Question[] {
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

        scoreText = findViewById(R.id.updatedScore);
        sum = scoreText.getText().toString();
        score = Integer.parseInt(sum); //converts string to int

        question = findViewById(R.id.quesTextView);
        currentQues = (Question) questionBank[1];
        //question.setText((CharSequence) currentQues);
        question.setText(R.string.question2);
    }

    @Override
    public void onClick(View view) {
        if(view == trueButton)
            checkAnswer(true);

        if(view == falseButton)
            checkAnswer(false);
    }

    private void checkAnswer(boolean userChoose) {
        //boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        // Getting correct answer of current question
        int toastMessageId;
        // If answer matches with the clicked button

        if (userChoose == currentQues.answerTrue) {
            score += 5;
            sum = new Integer(score).toString(); //converts int to string
            scoreText.setText(sum);
            toastMessageId = R.string.correct_answer;
            //RandQuestion();
        }
        else {
            toastMessageId = R.string.wrong_answer;
            //RandQuestion();
        }

        Toast.makeText(this, toastMessageId, Toast.LENGTH_SHORT).show();
    }

    private void generateQuestion(){
        //int randQuesNum = rand.nextInt(5);
        Question randQues = questionBank[rand.nextInt(questionBank.length)];
        //question.setText(R.string.question1);
        String ba = randQues.toString();
        question.setText(ba);
    }
}
