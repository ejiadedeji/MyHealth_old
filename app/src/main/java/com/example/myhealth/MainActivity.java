package com.example.myhealth;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.TextView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity {
    Button btnNext;
    TextView txtError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNext = findViewById(R.id.btnNext);
        txtError = findViewById(R.id.txtError);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText txtFirstName = findViewById(R.id.txtFirstName);
                EditText txtLastName = findViewById(R.id.txtLastName);
                EditText txtEmailAddress = findViewById(R.id.txtEmailAddress);

                if (!txtFirstName.getText().toString().matches("") && !txtLastName.getText().toString().matches("") && !txtEmailAddress.getText().toString().matches("") && isEmailValid(txtEmailAddress.getText().toString()))  {
                    moveToDetails();
                }
                else{
                    txtError.setText("Input Error");
                }
            }
        });
    }
    private void moveToDetails(){
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        startActivity (intent);
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
