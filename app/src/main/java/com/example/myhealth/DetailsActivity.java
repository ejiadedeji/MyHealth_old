package com.example.myhealth;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    EditText txtWeight;
    EditText txtHeight;
    Button btnCalculateBMI;
    TextView txtBMIResult;
    TextView txtBMIResultDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txtWeight = findViewById(R.id.txtWeight);
        txtHeight = findViewById(R.id.txtHeight);

        btnCalculateBMI = findViewById(R.id.btnCalculateBMI);
        txtBMIResult = findViewById(R.id.txtBMIResult);
        txtBMIResultDesc = findViewById(R.id.txtBMIResultDesc);



        btnCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double height = Double.parseDouble(txtHeight.getText().toString());
                double weight = Double.parseDouble(txtWeight.getText().toString());
                txtBMIResult.setText(getBMI(height, weight)[0]);
                txtBMIResultDesc.setText(getBMI(height, weight)[1]);
            }
        });
    }

    private String[] getBMI(double height, double weight){

        try {
            double result = weight / (height * height);
            String[] bmi = new String[2];
            bmi[0] = String.format("%.2f", result);
            bmi[1] = getBMIDescription(result);
            return bmi;
        }
        catch(Exception e) {
            return new String[]{"error", "error"};
        }

    }

    private String getBMIDescription(double bmi){
        if (bmi >= 29.9){
            return "Obese";
        }
        if (bmi >= 24.9){
            return "Overweight";
        }
        if (bmi >= 18.5){
            return "Normal BMI";
        }
        return "Underweight";
    }
}
