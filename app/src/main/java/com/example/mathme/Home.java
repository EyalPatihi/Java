package com.example.mathme;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    ImageButton speaker;
    MediaPlayer song;
    boolean play = true;
    Button diffiLevels;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        song= MediaPlayer.create(Home.this, R.raw.clas);

        diffiLevels = findViewById(R.id.diffiLevelBtn);
        diffiLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Levels.class);
                startActivity(intent);
            }
        });

        speaker = findViewById(R.id.speakerBtn);
        PlayIt();
        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(play)
                    StopIt();
                else
                    PlayIt();
            }
        });

    }
    public void Instructions (View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create(); //הוראות הפעלה. ברגע שלוחצים על כפתור אינסטרקשיין אז זה נכנס למתודה הזאת.
        alertDialog.setTitle(R.string.Instructions);
        //alertDialog.setMessage(R.string.InstructionsText);
        //alertDialog.setIcon(R.drawable.welcome);
        //alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener())
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        //{
        //public void onClick(DialogInterface dialog, int which) {
        //Toast.makeText(getApplicationContext(), "You clicked on OK", Toast.LENGTH_SHORT).show();
        //}
        //});
        alertDialog.show();
        // Toast instructions= Toast.makeText(this, "bla", Toast.LENGTH_LONG) ;// Toast-   פשוט לייצר הודעה על המסך. פה אנחנו רוצים לייצר על פופאפ לכן עשינו על דיס. ואז נגדיר איזה הודעה נרצה להציג. אז יצרנו בקובץ הסטרינג את ההודעה. ואז כמה זמן זה יוצג..
        // instructions.show();
        // InstructionsTextView.setText(Integer.toString(4));
        //  InstructionsTextView.setText("מ"תוצאות המשחקים יישמרו בטבלת השיאים ותוכל\\י לצפות בהן בסיום המשחק.\n");
    }

    public void PlayIt () {
        song.start();
        speaker.setBackgroundResource(R.drawable.speaker_on);
        play = true;
    }

    public void StopIt ()  {
        song.pause();
        speaker.setBackgroundResource(R.drawable.speaker_off);
        play = false;
    }
}