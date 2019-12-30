package ru.dkalugin.ski_forecaster.condition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import ru.dkalugin.ski_forecaster.R;

public class Crude extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crude);

        Intent intent = getIntent();
        String temperature = intent.getStringExtra("temperature");

        TextView tex_temperature = (TextView) findViewById(R.id.text_temperature_crude);
        tex_temperature.setText("t " + temperature);
    }
}
