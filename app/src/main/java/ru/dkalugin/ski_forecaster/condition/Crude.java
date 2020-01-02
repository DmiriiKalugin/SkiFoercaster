package ru.dkalugin.ski_forecaster.condition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ru.dkalugin.ski_forecaster.R;

public class Crude extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crude);

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        String temperature = intent.getStringExtra("temperature");

        TextView tex_temperature = (TextView) findViewById(R.id.text_temperature_crude);
        tex_temperature.setText("t " + temperature);

        int t =  Integer.parseInt (temperature);

        TextView paraphin = (TextView) findViewById(R.id.paraphin_crude);
        TextView powers_accelerator = (TextView) findViewById(R.id.powders_accelerators_2_crude);


        if (t > 5 && t <= 10){
            paraphin.setText(getString(R.string.paraphins_crude_plus_6_10));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_plus_6_10));
        }
        else if (t >=3 && t <= 5){
            paraphin.setText(getString(R.string.paraphins_crude_plus_3_5));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_plus_3_5));
        }
        else if (t >= 1 && t <= 2 ){
            paraphin.setText(getString(R.string.paraphins_crude_plus_2_1));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_plus_2_1));
        }
        else if (t ==0 ){
            paraphin.setText(getString(R.string.paraphins_crude_0));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_0));
        }
        else if (t <= -1 && t >= -2 ){
            paraphin.setText(getString(R.string.paraphins_crude_minus_1_2));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_minus_1_2));
        }
        else if (t == -3 ){
            paraphin.setText(getString(R.string.paraphins_crude_minus_3));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_minus_3));
        }
        else if (t <= -4 && t >= -5){
            paraphin.setText(getString(R.string.paraphins_crude_minus_4_5));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_minus_4_5));
        }
        else if (t <= -6 && t >= -7){
            paraphin.setText(getString(R.string.paraphins_crude_minus_6_7));
            powers_accelerator.setText(getString(R.string.powders_accelerators_crude_minus_6_7));
        }
        else {
            paraphin.setText("Для данной температуры, нет данных");
            powers_accelerator.setText("Для данной температуры, нет данных");
        }
    }
}
