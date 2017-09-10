package com.example.sakshi.insertimagedatabase_acad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    DataHandler dataHandler;
    ArrayList<Data> datas;
    TextView name,age;
    ImageView image;
    Data data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dataHandler = new DataHandler(Main2Activity.this);
        name = (TextView) findViewById(R.id.name);
        datas = new ArrayList<>();
        data = new Data();
        age = (TextView) findViewById(R.id.age);
        image = (ImageView) findViewById(R.id.image);
        //getting all data from the database
        datas = dataHandler.getAlldata();
        //if the array list is not empty
        if (!datas.isEmpty()) {
            for (int i = 0; i < datas.size(); i++) {
                Data data = (Data) datas.get(i);
                name.setText(data.getName());
                age.setText(data.getAge());
                //setting bitmap to the imageview
                image.setImageBitmap(data.getEmployeePhoto());
            }
        }
        else{
            Toast.makeText(this, "No data in database", Toast.LENGTH_SHORT).show();
        }
    }
}
