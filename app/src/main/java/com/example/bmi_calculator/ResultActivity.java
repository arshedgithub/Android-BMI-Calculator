package com.example.bmi_calculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView bmiStatusTxt;
    TextView bmiValue;
    String bmistatus;
    int bmistatusColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        bmiStatusTxt = findViewById(R.id.bmi_status);
        bmiValue = findViewById(R.id.bmi_value);

        Intent intent = getIntent();
        float data = intent.getExtras().getFloat("bmi");

        if (data > 40){
            bmistatus = "Obese class III";
            bmistatusColor = R.color.status_1;
        } else if (data > 35){
            bmistatus = "Obese class II";
            bmistatusColor = R.color.status_2;
        } else if (data > 30){
            bmistatus = "Obese class I";
            bmistatusColor = R.color.status_3;
        } else if (data > 25){
            bmistatus = "Overweight";
            bmistatusColor = R.color.status_4;
        } else if (data > 18.5){
            bmistatus = "Normal";
            bmistatusColor = R.color.status_5;
        } else if (data > 17){
            bmistatus = "Mid Thinness";
            bmistatusColor = R.color.status_4;
        } else if (data > 16){
            bmistatus = "Moderate Thinness";
            bmistatusColor = R.color.status_2;
        } else {
            bmistatus = "Severe Thinness";
            bmistatusColor = R.color.status_1;
        }

        bmiStatusTxt.setText(bmistatus);

        // rounded up to first decimal place
        double roundedValue = Math.floor(data * 10) / 10.0;
        bmiValue.setText("BMI = " + roundedValue + " kg/m2");
        bmiStatusTxt.setTextColor(getColor(bmistatusColor));

    }
}