package ru.dkalugin.ski_forecaster.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

import ru.dkalugin.ski_forecaster.ski_forecaster.SkiForecaster;
import ru.dkalugin.ski_forecaster.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, SkiForecaster.class);
        startActivity(intent);
        finish();
    }
}
