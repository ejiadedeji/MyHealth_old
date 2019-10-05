package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Spinner;;

import android.os.Bundle;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner genderSpinner = findViewById(R.id.genderSpinner);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1, getResources()
                        .getStringArray(R.array.genders));

        myAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        genderSpinner.setAdapter(myAdapter);


    }
}
