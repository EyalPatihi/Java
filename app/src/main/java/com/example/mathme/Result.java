package com.example.mathme;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {
    TextView score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        score= findViewById(R.id.Score);
        int point=getIntent().getIntExtra("score",0);
        score.setText(point+ "");
    }
    public void rest(View view)
    {
        startActivity(new Intent(getApplicationContext(), Levels.class ));
    }
    public void end(View view)
    {
        startActivity(new Intent(getApplicationContext(), Home.class ));
    }

}