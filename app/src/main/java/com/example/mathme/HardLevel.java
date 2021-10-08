package com.example.mathme;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import androidx.appcompat.app.AppCompatActivity;

public class HardLevel extends AppCompatActivity implements View.OnClickListener {

    Random rand = new Random();
    Button checkButton;
    boolean clicked = false;
    int randNum1 = rand.nextInt(99);
    int randNum2 = rand.nextInt(99);
    //String[] opsArr = {"+", "-", "*", "/"};
    String[] opsArr = {"+", "-"};
    String randOp = opsArr[rand.nextInt(2)];
    String str, str1;
    int correctAnswer = 0;
    int numFromUser;
    int score = 0;

    TextView scoreText;
    TextView num1Tv;
    TextView num2Tv;
    TextView opTv;
    EditText answerFromUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level);

        num1Tv = findViewById(R.id.num1Tv);

        num2Tv = findViewById(R.id.num2Tv);

        opTv = findViewById(R.id.opTv);
        //str = new String(randOp).toString();

        answerFromUser = findViewById(R.id.resultEt);

        scoreText = findViewById(R.id.scoreHard);

        checkButton = findViewById(R.id.checkBtn);
        checkButton.setOnClickListener(this);


        for (int i = 1; i <= 5; i++) {
            //int randNum1 = rand.nextInt(99);
            //int randNum2 = rand.nextInt(99);
            //String randOp = opsArr[rand.nextInt(2)];

            str = new Integer(randNum1).toString();
            num1Tv.setText(str);

            str = new Integer(randNum2).toString();
            num2Tv.setText(str);

            opTv.setText(randOp);

            if(randNum2 > randNum1)
                break;

            if(clicked)
                checkAnswer();
        }
    }

    @Override
    public void onClick (View view){
        if (view == checkButton) {
            clicked = true;
            checkAnswer();
        }
    }

        //sum = scoreText.getText().toString();
        //score = Integer.parseInt(sum); //converts string to int
        //scoreText.setText();

    public void checkAnswer() {
        str1 = answerFromUser.getText().toString();
        numFromUser = Integer.parseInt(String.valueOf(str1));
        switch (randOp) {
            case "+":
                correctAnswer = randNum1 + randNum2;
                break;

            case "-":
                correctAnswer = randNum1 - randNum2;
                break;

            /*case "*":
                correctAnswer = randNum1 * randNum2;
                break;

            case "/":
                correctAnswer = randNum1 / randNum2;
                break;*/
        }
        if (numFromUser == correctAnswer) {
            Toast.makeText(HardLevel.this, "Correct!", Toast.LENGTH_SHORT).show();
            score += 5;
            String sum = new Integer(score).toString(); //converts int to string
            scoreText.setText(sum);
        }
        else {
            Toast.makeText(HardLevel.this, "Incorrect!", Toast.LENGTH_SHORT).show();
        }
        clicked = false;
    }

}
