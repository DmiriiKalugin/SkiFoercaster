package ru.dkalugin.ski_forecaster.temperature.plus5_10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import ru.dkalugin.ski_forecaster.R;
import ru.dkalugin.ski_forecaster.ski_forecaster.SkiForecaster;

public class Fresh extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh_pl_5_10);

        Intent intent = getIntent();
        String temperature = intent.getStringExtra("temperature");

        TextView tex_temperature = (TextView) findViewById(R.id.text_t_pl_5_10);
        tex_temperature.setText(temperature);


    }
}
