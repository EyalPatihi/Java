package com.example.mathme;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    private TextView InstructionsTextView;
    MediaPlayer song;
    int count;
    int i=0;// בשביל השיר- להפעיל או לכבות

    Button diffiLevels;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //InstructionsTextView=(TextView)findViewById(R.id.textView3);
        song= MediaPlayer.create(Home.this, R.raw.clas);
        song.start();
        count=0;

        diffiLevels = findViewById(R.id.diffiLevelBtn);
        diffiLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, Levels.class);
                startActivity(intent);
            }
        });
    }
    public void Instructions (View view)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(Home.this).create(); //הוראות הפעלה. ברגע שלוחצים על כפתור אינסטרקשיין אז זה נכנס למתודה הזאת.
        alertDialog.setTitle("הוראות הפעלה                               ");
        alertDialog.setMessage("הוראות הפעלה:\n" +
                "משחק לימודי מתמטי. \n" +
                "המשחק מחולק לפי דרגות קושי- קל, בינוני וקשה.\n" +
                "בכל משחק יש 5 שאלות, שעליהן צריך לענות כמה שיותר מהר. \n" +
                "תוצאות המשחקים יישמרו בטבלת השיאים ותוכל\\י לצפות בהן בסיום המשחק.\n");
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
    public void PlayIt (View view)
    {
        if (count == 1) {

            song = MediaPlayer.create(Home.this, R.raw.clas);
            song.start();
            i=0;
        }

        //song.stop();
        //}
        if (count == 0 && i==0)
        {
            count = 1;
            //song.start();
            song.stop();
        }
        //count = 1;
        //i=0;
    }

    public void StopIt (View view)
    {
        song.stop();
    }
}