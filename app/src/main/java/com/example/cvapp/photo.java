package com.example.cvapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.firebase.storage.StorageReference;

public class photo extends AppCompatActivity {

    Button ch, up,infobtn;
    ImageView img;
    StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        ch=(Button)findViewById(R.id.btnchoose);
        up=(Button)findViewById(R.id.btnupload);
        img=(ImageView) findViewById(R.id.imgview);

        infobtn=(Button) findViewById(R.id.infoBtn);
        infobtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(photo.this, GeneralInfo.class);
                startActivity(intent);
            }
        });




        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Filechooser();
            }
        });

    }
    private void Filechooser(){

        Intent intent = new Intent();
        intent.setType("image/' ");
        intent.setAction((Intent.ACTION_GET_CONTENT));
    }

}
