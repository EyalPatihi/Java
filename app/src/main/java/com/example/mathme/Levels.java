package com.example.mathme;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Levels extends AppCompatActivity implements View.OnClickListener {
    private Button easyLevel, normalLevel, hardLevel, backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        easyLevel = findViewById(R.id.easyBtn);
        easyLevel.setOnClickListener(this);

        normalLevel = findViewById(R.id.normalBtn);
        normalLevel.setOnClickListener(this);

        hardLevel = findViewById(R.id.hardBtn);
        hardLevel.setOnClickListener(this);

        backButton = findViewById(R.id.backBtn);
        backButton.setOnClickListener(this);
    }


    public void onClick(View view) {
        if (view == backButton) {
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }

        if(easyLevel == view){
            Intent intent = new Intent(this, EasyLevel.class);
            startActivity(intent);
            }
        if(normalLevel == view){
            Intent intent = new Intent(this, NormalLevel.class);
            startActivity(intent);
        }
        if(hardLevel == view){
            Intent intent = new Intent(this, HardLevel.class);
            startActivity(intent);
        }
    }

}