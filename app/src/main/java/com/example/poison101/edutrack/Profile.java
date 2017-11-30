package com.example.poison101.edutrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.poison101.edutrack.R.drawable.user;

public class Profile extends AppCompatActivity {

    TextView fname, id, sub1, sub2, sub3, sub4, sub5, sub6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fname = (TextView) findViewById(R.id.user_profile_name);
        id = (TextView) findViewById(R.id.user_profile_short_bio);
        sub1 = (TextView) findViewById(R.id.sub1);
        sub2 = (TextView) findViewById(R.id.sub2);
        sub3 = (TextView) findViewById(R.id.sub3);
        sub4 = (TextView) findViewById(R.id.sub4);
        sub5 = (TextView) findViewById(R.id.sub5);

        final DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference().child("students");
        rootRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("9509106101083")) {
                    fname.setText(dataSnapshot.child("9509106101083").child("Student_Details").child("Full_Name").getValue().toString());
                    id.setText("9509106101083");

                    sub1.setText(dataSnapshot.child("9509106101083").child("Academic_Results").child("Subject_One").child("sub1").getValue().toString());
                    sub2.setText(dataSnapshot.child("9509106101083").child("Academic_Results").child("Subject_Two").child("sub2").getValue().toString());
                    sub3.setText(dataSnapshot.child("9509106101083").child("Academic_Results").child("Subject_Three").child("sub3").getValue().toString());
                    sub4.setText(dataSnapshot.child("9509106101083").child("Academic_Results").child("Subject_Four").child("sub4").getValue().toString());
                    sub5.setText(dataSnapshot.child("9509106101083").child("Academic_Results").child("Subject_Five").child("sub5").getValue().toString());
                }else{
                    Toast.makeText(Profile.this, "Student not available", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
