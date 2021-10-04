package com.example.mathme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText emailId,password;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId= findViewById(R.id.EmailRegister);
        password = findViewById(R.id.PasswordRegister);
        tvSignUp=findViewById(R.id.AlredayHaveAnAccount);
        btnSignIn = findViewById(R.id.SignUpBtn);

        authStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                if(!(firebaseUser!= null))
                {
                    Toast.makeText(LoginActivity.this,"you are in!",Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(LoginActivity.this, Home.class);
                    startActivity(i);

                }
                else
                {
                    Toast.makeText(LoginActivity.this,"DRAKARIS!!",Toast.LENGTH_SHORT).show();
                }

            }

        };

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("please enter email id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("please enter password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Filds are empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful())
                            {
                                Toast.makeText(LoginActivity.this, "we have an  error MotherLover", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent intToHome = new Intent(LoginActivity.this, Home.class);
                                startActivity(intToHome);
                            }
                        }
                    });

                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Error,goddamm!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intSignUp);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(authStateListener);
    }
}