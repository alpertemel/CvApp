package com.example.cvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class education extends AppCompatActivity {

    private Firebase Ref;
    EditText edu;
    Button save,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        edu=(EditText)findViewById(R.id.education);
        save=(Button) findViewById(R.id.saveEdu);
        next=(Button) findViewById(R.id.nextEdu);

        Firebase.setAndroidContext(this);
        Ref=new Firebase("https://cvapp-8ab28.firebaseio.com/");

        next = (Button)findViewById(R.id.nextEdu);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(education.this, work.class);
                startActivity(intent);
            }
        });
    }

    public void feedbacksent (View view){

        String eduinput=edu.getText().toString();

        Firebase ReEdu=Ref.child("Education").push();
        ReEdu.setValue(eduinput);


        Toast.makeText(getApplicationContext(),"We Saved Your General Information !",Toast.LENGTH_LONG).show();
    }

}
