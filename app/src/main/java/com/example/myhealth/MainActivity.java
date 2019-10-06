package com.example.myhealth;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    EditText txtDateOfBirth;
    Button btnDateOfBirth;
    Calendar c;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDateOfBirth = findViewById(R.id.txtDateOfBirth);
        btnDateOfBirth = findViewById(R.id.btnDateOfBirth);
        btnNext = findViewById(R.id.btnNext);

        Spinner genderSpinner = findViewById(R.id.spnGender);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>
                (MainActivity.this, android.R.layout.simple_list_item_1, getResources()
                        .getStringArray(R.array.genders));

        myAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        genderSpinner.setAdapter(myAdapter);

        btnDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);
                DatePickerDialog dpd = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDay) {
                      txtDateOfBirth.setText(mMonth + 1 + "/" + mDay + "/" + mYear);
                    }
                }, year, month, day);
                dpd.show();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtFirstName = findViewById(R.id.txtFirstName);
                EditText txtLastName = findViewById(R.id.txtFirstName);
                EditText txtEmailAddress = findViewById(R.id.txtEmailAddress);
                Spinner spnGender = findViewById(R.id.spnGender);
                txtEmailAddress.setError("hi");

                moveToDetails();
            }
        });

        txtDateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(txtDateOfBirth.getText().toString()).matches()==false){
                    txtDateOfBirth.setError("Invalid Date of Birth");
                }
            }
        });


    }

    private void moveToDetails(){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity (intent);
    }


}
