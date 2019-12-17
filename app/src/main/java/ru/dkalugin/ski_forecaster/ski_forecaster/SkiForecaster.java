package ru.dkalugin.ski_forecaster.ski_forecaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.dkalugin.ski_forecaster.R;
import ru.dkalugin.ski_forecaster.temperature.plus5_10.Fresh;

public class SkiForecaster extends AppCompatActivity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ski_forecaster);

        Button btn_fresh = (Button) findViewById(R.id.btn_fresh);
        Button btn_old = (Button) findViewById(R.id.btn_old);
        Button btn_crude = (Button) findViewById(R.id.btn_crude);
        Button btn_artificial = (Button) findViewById(R.id.btn_artificial);

        btn_fresh.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent fresh = new Intent(this, Fresh.class);
        startActivity(fresh);
    }


}
