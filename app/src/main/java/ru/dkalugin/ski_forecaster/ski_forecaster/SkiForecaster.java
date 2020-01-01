package ru.dkalugin.ski_forecaster.ski_forecaster;




import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.dkalugin.ski_forecaster.R;
import ru.dkalugin.ski_forecaster.condition.Arcificial;
import ru.dkalugin.ski_forecaster.condition.Crude;
import ru.dkalugin.ski_forecaster.condition.Fresh;
import ru.dkalugin.ski_forecaster.condition.Old;

public class   SkiForecaster extends AppCompatActivity  implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ski_forecaster);


        Button btn_fresh = (Button) findViewById(R.id.btn_fresh);
        Button btn_old = (Button) findViewById(R.id.btn_old);
        Button btn_crude = (Button) findViewById(R.id.btn_crude);
        Button btn_artificial = (Button) findViewById(R.id.btn_artificial);

        btn_fresh.setOnClickListener(this);
        btn_old.setOnClickListener(this);
        btn_crude.setOnClickListener(this);
        btn_artificial.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        EditText air_temperature = (EditText) findViewById(R.id.air_temperature);
        String temperature = air_temperature.getText().toString();

        final ProgressDialog progressDialog = new ProgressDialog(SkiForecaster.this, R.style.MyTheme);
        progressDialog.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
        progressDialog.show();
//        After 2 Seconds i dismiss progress Dialog

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


        switch (v.getId()){
            case R.id.btn_fresh:
                Intent fresh = new Intent(this, Fresh.class);
                fresh.putExtra("temperature", temperature);
                startActivity(fresh);
                break;
            case R.id.btn_old:
                Intent old = new Intent(this, Old.class);
                old.putExtra("temperature", temperature);
                startActivity(old);
                break;
            case R.id.btn_crude:
                Intent crude = new Intent(this, Crude.class);
                crude.putExtra("temperature", temperature);
                startActivity(crude);
                break;
            case R.id.btn_artificial:
                Intent artificial = new Intent(this, Arcificial.class);
                artificial.putExtra("temperature", temperature);
                startActivity(artificial);
                break;

        }


    }


}
