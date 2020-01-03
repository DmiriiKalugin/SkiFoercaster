package ru.dkalugin.ski_forecaster.condition;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ru.dkalugin.ski_forecaster.R;
import ru.dkalugin.ski_forecaster.ski_forecaster.SkiForecaster;

public class Fresh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh);


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = getIntent();
        String temperature = intent.getStringExtra("temperature");
        TextView tex_temperature = (TextView) findViewById(R.id.text_temperature_fresh);
        tex_temperature.setText("t " + temperature);

        int t =  Integer.parseInt (temperature);

        TextView humidity = (TextView) findViewById(R.id.humidity_2_fresh);
        TextView paraphin = (TextView) findViewById(R.id.paraphin_fresh);
        TextView powers_accelerator = (TextView) findViewById(R.id.powders_accelerators_2_fresh);

        if (t <=-18 && t >=-35){
            humidity.setText(getString(R.string.forty_five_ninety));
        }

        if (t > 5 && t <= 10){
            paraphin.setText(getString(R.string.paraphins_fresh_plus_6_10));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_plus_6_10));
        }
        else if (t >=3 && t <= 5){
            paraphin.setText(getString(R.string.paraphins_fresh_plus_3_5));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_plus_3_5));
        }
        else if (t >= 1 && t <= 2 ){
            paraphin.setText(getString(R.string.paraphins_fresh_plus_2_1));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_plus_2_1));
        }
        else if (t ==0 ){
            paraphin.setText(getString(R.string.paraphins_fresh_0));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_0));
        }
        else if (t <= -1 && t >= -2 ){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_1_2));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_1_2));
        }
        else if (t == -3 ){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_3));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_3));
        }
        else if (t <= -4 && t >= -5){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_4_5));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_4_5));
        }
        else if (t <= -6 && t >= -7){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_6_7));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_6_7));
        }
        else if (t <= -8 && t >= -9){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_8_9));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_8_9));
        }
        else if (t <= -10 && t >= -11){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_10_11));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_10_11));
        }
        else if (t <= -12 && t >= -13){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_12_13));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_12_13));
        }
        else if (t <= -14 && t >= -15){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_14_15));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_14_15));
        }
        else if (t <= -16 && t >= -17){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_16_17));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_16_17));
        }
        else if (t <= -18 && t >= -19){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_18_19));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_18_19));
        }
        else if (t <= -20 && t >= -21){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_20_21));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_20_21));
        }
        else if (t <= -22 && t >= -23){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_22_23));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_22_23));
        }
        else if (t <= -24 && t >= -25){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_24_25));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_24_25));
        }
        else if (t <= -26 && t >= -30){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_26_30));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_26_30));
        }
        else if (t <= -31 && t >= -35){
            paraphin.setText(getString(R.string.paraphins_fresh_minus_31_35));
            powers_accelerator.setText(getString(R.string.powders_accelerators_fresh_minus_31_35));
        }
        else {
            paraphin.setText("Для данной температуры, нет данных");
            powers_accelerator.setText("Для данной температуры, нет данных");
        }
    }
}
