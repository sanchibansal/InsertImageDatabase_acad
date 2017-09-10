package com.example.sakshi.insertimagedatabase_acad;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import static android.R.attr.bitmap;

public class MainActivity extends AppCompatActivity {

    Button show, insert;
    EditText name, age;
    DataHandler  dataHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show = (Button) findViewById(R.id.show);
        insert = (Button) findViewById(R.id.insert);
        dataHandler = new DataHandler(MainActivity.this);
        name = (EditText) findViewById(R.id.first);
        age = (EditText) findViewById(R.id.age);
        //onclick listener for show button
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //takes to the next screen
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating bitmap of the image from the drawable folder
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                //compressing bitmap
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, stream);
                //inserting data into database
                Boolean status = dataHandler.insert_Data(name.getText().toString(),age.getText().toString(),stream.toByteArray());
                if(status){
                    Toast.makeText(MainActivity.this, "Inserted into database", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "can not insert", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
