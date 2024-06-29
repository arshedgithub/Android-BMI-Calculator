package com.example.bmi_calculator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.window.OnBackInvokedDispatcher;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

                float heightInM = heightValue/100;
                float bmiValue = weightValue / (heightInM * heightInM);
                Toast.makeText(getApplicationContext(), String.valueOf(bmiValue), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), ResultActivity.class);
                intent.putExtra("bmi", bmiValue);
                startActivity(intent);

            }
        });

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Exit")
                .setMessage("Do you want to exit from the App?")
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
