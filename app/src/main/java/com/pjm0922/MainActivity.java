package com.pjm0922;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView kg2, cm2, bmi2, result2;
    SeekBar skb_kg2, skb_cm2;

    float result_kg = 0.0f, result_cm = 0.0f, result_bmi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        skb_kg2 = findViewById(R.id.skb_kg1);
        kg2 = findViewById(R.id.kg1);
        skb_cm2 = findViewById(R.id.skb_cm1);
        cm2 = findViewById(R.id.cm1);
        bmi2 = findViewById(R.id.bmi1);
        result2 = findViewById(R.id.result1);

        setTitle("BMI");

        skb_kg2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                result_kg = (progress * 0.5f + 35);
                kg2.setText(String.format("%.1f kg",result_kg));
                bmi_calculator(result_cm / 100, result_kg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        skb_cm2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                result_cm = (progress * 0.5f + 90);
                cm2.setText(String.format("%.1f cm",result_cm));
                bmi_calculator(result_cm / 100 , result_kg);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    private void bmi_calculator(float cm, float kg) {
        result_bmi =  kg / (cm * cm);
        bmi2.setText(String.format("BMI : %.2f", result_bmi));

        if (result_bmi <= 18.5f){
            result2.setText("당신은 저체중입니다!");
        } else if(result_bmi > 18.5f && result_bmi < 23.0f) {
            result2.setText("당신은 정상 체중입니다!");
        } else if (result_bmi >= 23.0f && result_bmi < 25.0f) {
            result2.setText("당신은 과체중입니다!");
        } else if (result_bmi >= 25.0f) {
            result2.setText("당신은 비만입니다!");
        }
    }
}