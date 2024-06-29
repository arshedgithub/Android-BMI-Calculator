package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.btn_calc);
        EditText age = (EditText) findViewById(R.id.age_input);
        EditText height = (EditText) findViewById(R.id.height_input);
        EditText weight = (EditText) findViewById(R.id.weight_input);


        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (age.getText().toString().matches("") || height.getText().toString().matches("") || weight.getText().toString().matches("")){
                    Toast.makeText(getApplicationContext(), "Required Field Empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                int ageValue = Integer.parseInt(age.getText().toString());
                float heightValue = Float.valueOf(height.getText().toString());
                float weightValue = Float.valueOf(weight.getText().toString());

                if (ageValue < 18){
                    Toast.makeText(getApplicationContext(), "Age should be 18 or above", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (ageValue == 0 || heightValue == 0.0 || weightValue == 0.0){
                    Toast.makeText(getApplicationContext(), "Invalid value", Toast.LENGTH_SHORT).show();
                    return;
                }

                float bmiValue = weightValue / (heightValue * heightValue);
                Toast.makeText(getApplicationContext(), String.valueOf(bmiValue), Toast.LENGTH_SHORT).show();

            }
        });
    }
}