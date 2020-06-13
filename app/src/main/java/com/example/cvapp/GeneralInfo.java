package com.example.cvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class GeneralInfo extends AppCompatActivity {

    private Firebase Ref;
    EditText info;
    Button save,next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_info);

        info=(EditText)findViewById(R.id.info);
        save=(Button) findViewById(R.id.saveBtn);
        next=(Button) findViewById(R.id.nextBtn);

        Firebase.setAndroidContext(this);
        Ref=new Firebase("https://cvapp-8ab28.firebaseio.com/");
    }
    public void feedbacksent (View view){

        String infoinput=info.getText().toString();

        Firebase Reinfo=Ref.child("info").push();
        Reinfo.setValue(infoinput);


        Toast.makeText(getApplicationContext(),"We Saved Your General Information !",Toast.LENGTH_LONG).show();
    }
}
