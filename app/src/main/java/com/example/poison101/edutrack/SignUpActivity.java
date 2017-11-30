package com.example.poison101.edutrack;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

import static android.R.attr.button;

public class SignUpActivity extends Activity {

    EditText inputEmail, inputPassword;
    Button buttonLogin, buttonConfirm;
    TextInputLayout t1, t2;
    StudentClass aClass = new StudentClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        t1 = (TextInputLayout) findViewById(R.id.text1);
        t2 = (TextInputLayout) findViewById(R.id.text12);

        inputEmail = (EditText) findViewById(R.id.input_email);
        inputPassword = (EditText) findViewById(R.id.input_password);
        buttonLogin = (Button) findViewById(R.id.btn_login);
        buttonConfirm = (Button) findViewById(R.id.btn_signup);

        inputPassword.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        buttonConfirm.setVisibility(View.GONE);


        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("students");
                rootRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(inputEmail.getText().toString().trim())) {

                            startActivity(new Intent(SignUpActivity.this, MainActivity.class));

                            Toast.makeText(SignUpActivity.this, "Welcome to EduTrack!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Student not available", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("students");
                rootRef.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild(inputEmail.getText().toString().trim())) {
                            // run some codeT
                            inputEmail.setVisibility(View.GONE);
                            t1.setVisibility(View.GONE);
                            buttonLogin.setVisibility(View.GONE);

                            inputPassword.setVisibility(View.VISIBLE);
                            t2.setVisibility(View.VISIBLE);
                            buttonConfirm.setVisibility(View.VISIBLE);

                            Toast.makeText(SignUpActivity.this, "First time user, Create a password!!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(SignUpActivity.this, "Invalid ID Number", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}