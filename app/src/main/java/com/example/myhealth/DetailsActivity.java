package com.example.myhealth;

import androidx.appcompat.app.AppCompatActivity;

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
        txtBMI = findViewById(R.id.txtBMI);
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
                double height = Double.parseDouble(txtHeight.getText().toString());
                double weight = Double.parseDouble(txtWeight.getText().toString());
                String heightUnit = spnHeightUnit.getSelectedItem().toString();
                String weightUnit = spnWeightUnit.getSelectedItem().toString();
                txtBMI.setText(getBMI(height, heightUnit, weight, weightUnit));
            }
        });

    }

    private String getBMI(double height, String heightUnit, double weight, String weightUnit){
        double mHeight = height;
        double mWeight = weight;

        if (heightUnit == "m"){
            mHeight = height;
        }

        if (heightUnit == "fts"){
            mHeight = height * 0.3048;
        }

        if (weightUnit == "kg"){
            mWeight = weight;
        }

        if (weightUnit == "Lbs"){
            mWeight = weight * 0.3048;
        }

        String bmi = Double.toString(mWeight/(mHeight * mHeight));

        return bmi;
    }
}
