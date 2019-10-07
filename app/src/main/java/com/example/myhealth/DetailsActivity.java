package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    EditText txtWeight;
    EditText txtHeight;
    TextView txtBMI;
    Button btnCalculateBMI;
    Spinner spnHeightUnit;
    Spinner spnWeightUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtWeight = findViewById(R.id.txtWeight);
        txtHeight = findViewById(R.id.txtHeight);
        txtBMI = findViewById(R.id.txtBMIResult);
        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);

        spnHeightUnit = findViewById(R.id.spnHeightUnit);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (DetailsActivity.this, android.R.layout.simple_list_item_1, getResources()
                        .getStringArray(R.array.unitHeight));
        myAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnHeightUnit.setAdapter(myAdapter);


        spnWeightUnit = findViewById(R.id.spnWeightUnit);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>
                (DetailsActivity.this, android.R.layout.simple_list_item_1, getResources()
                        .getStringArray(R.array.unitWeight));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spnWeightUnit.setAdapter(myAdapter2);


        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = 0;
                double weight = 0;
                if (spnHeightUnit.getSelectedItem().toString().matches("m")) {
                    height = Double.parseDouble(txtHeight.getText().toString());
                }
                if (spnHeightUnit.getSelectedItem().toString().matches("fts")) {
                    height = Double.parseDouble(txtHeight.getText().toString()) * 0.3048;
                }

                if (spnWeightUnit.getSelectedItem().toString().matches("kg")) {
                    weight = Double.parseDouble(txtWeight.getText().toString());
                }
                if (spnWeightUnit.getSelectedItem().toString().matches("Lbs")) {

                    weight = Double.parseDouble(txtWeight.getText().toString()) * 0.453592;
                }
                txtBMI.setText(getBMI(height, weight)[1]);


                Intent intent = new Intent(DetailsActivity.this, ResultActivity.class);
                intent.putExtra("BMI", getBMI(height, weight));
                startActivity (intent);
            }
        });

    }

    private String[] getBMI(double height, double weight){
        double result = weight/(height * height);
        String[] bmi = new String[2];
        bmi[0] = String.format("%.2f", result);
        bmi[1] = getBMIDescription(result);
        return bmi;

    }

    private String getBMIDescription(double bmi){
        String desc;
        if (bmi <= 18){
            return "Underweight";
        }

        if (bmi >= 30){
            return "Overweight";
        }

        return "Normal BMI";

    }
}
