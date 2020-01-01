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
    }
}
