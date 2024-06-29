package com.example.bmi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView bmiStatus;
    TextView bmiValue;
    String bmistatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        bmiStatus = findViewById(R.id.bmi_status);
        bmiValue = findViewById(R.id.bmi_value);

        Intent intent = getIntent();
        float data = intent.getExtras().getFloat("bmi");

        if (data > 40){
            bmistatus = "Obese class III";
        } else if (data > 35){
            bmistatus = "Obese class II";
        } else if (data > 30){
            bmistatus = "Obese class I";
        } else if (data > 25){
            bmistatus = "Overweight";
        } else if (data > 18.5){
            bmistatus = "Normal";
        } else if (data > 17){
            bmistatus = "Mid Thinness";
        } else if (data > 16){
            bmistatus = "Moderate Thinness";
        } else {
            bmistatus = "Severe Thinness";
        }
        // rounded up to first decimal place
        double roundedValue = Math.floor(data * 10) / 10.0;
        bmiValue.setText("BMI = " + roundedValue + " kg/m2");

    }
}