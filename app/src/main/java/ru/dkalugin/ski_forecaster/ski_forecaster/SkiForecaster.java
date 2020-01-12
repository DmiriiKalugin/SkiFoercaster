package ru.dkalugin.ski_forecaster.ski_forecaster;


/**
 * Разработчик приложения
 * Калугин Дмитрий Игоревич
 **/



import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import ru.dkalugin.ski_forecaster.R;
import ru.dkalugin.ski_forecaster.about.About;
import ru.dkalugin.ski_forecaster.condition.Arcificial;
import ru.dkalugin.ski_forecaster.condition.Crude;
import ru.dkalugin.ski_forecaster.condition.Fresh;
import ru.dkalugin.ski_forecaster.condition.Old;

public class   SkiForecaster extends AppCompatActivity  implements View.OnClickListener {

    private static final String PREFERENCE_NAME = "System.io";
    private static final String PREFERENCE_TIME = "times";


    private static int value = 0;

    private static int time_art = 0;

    private static long current_time = 0;

    SharedPreferences preferences;
    SharedPreferences time;
    SharedPreferences.Editor ed_time;
    String run_more;


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

        TextView about_list = (TextView) findViewById(R.id.about_list);

        about_list.setOnClickListener(this);

        Date date = new Date();

        current_time =  date.getTime()/1000/60/60 - 438000;
        time_art = (int) current_time;
        time = getPreferences(MODE_PRIVATE);

        System.out.println(value);
        System.out.println(time_art);
        System.out.println(time.getInt(PREFERENCE_TIME, 0));

        if (value > 5){
            if ((time_art) >= time.getInt(PREFERENCE_TIME, 0)){
                value = 0;
                ed_time = time.edit();
                ed_time.clear();
                ed_time.apply();

            }
            else {
                finish();
                Toast.makeText(this,  "Лимит запусков исчерпан" , Toast.LENGTH_LONG).show();
            }

        }


    }

    @Override
    public void onResume() {
        super.onResume();

        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PREFERENCE_NAME, value);
        editor.apply();


        if (preferences.getInt(PREFERENCE_NAME, 0) < 5) {
            if (preferences.getInt(PREFERENCE_NAME, 0) == 4) {
                ed_time = time.edit();
                ed_time.clear();
                ed_time.apply();

                run_more = "Это последний просмотр";
                Toast.makeText(this, run_more, Toast.LENGTH_SHORT).show();
            }
            value++;
            if(value == 5){
                ed_time = time.edit();
                ed_time.putInt(PREFERENCE_TIME, time_art + 24);
                ed_time.apply();

                value++;
            }
        }
        else {
            finish();
            Toast.makeText(this,  "Лимит запусков исчерпан" , Toast.LENGTH_LONG).show();
        }
    }


    private void openSiteDialog() {


        final SpannableString webaddress = new SpannableString(
                "Не указана температура воздуха!!!!");
        Linkify.addLinks(webaddress, Linkify.ALL);

        final AlertDialog aboutDialog = new AlertDialog.Builder(
                SkiForecaster.this).setMessage(webaddress)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                    }
                }).create();

        aboutDialog.show();
        ((TextView) aboutDialog.findViewById(android.R.id.message))
                .setMovementMethod(LinkMovementMethod.getInstance());
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
                if(air_temperature.getText().toString().equals("")){
                    openSiteDialog();
                }
                else {
                    startActivity(fresh);
                }

                break;
            case R.id.btn_old:
                Intent old = new Intent(this, Old.class);
                old.putExtra("temperature", temperature);
                if(air_temperature.getText().toString().equals("")){
                    openSiteDialog();
                }
                else {
                    startActivity(old);
                }
                break;
            case R.id.btn_crude:
                Intent crude = new Intent(this, Crude.class);
                crude.putExtra("temperature", temperature);
                if(air_temperature.getText().toString().equals("")){
                    openSiteDialog();
                }
                else {
                    startActivity(crude);
                }
                break;
            case R.id.btn_artificial:
                Intent artificial = new Intent(this, Arcificial.class);
                artificial.putExtra("temperature", temperature);
                if(air_temperature.getText().toString().equals("")){
                    openSiteDialog();
                }
                else {
                    startActivity(artificial);
                }
                break;

            case R.id.about_list:
                Intent about = new Intent(this, About.class);
                startActivity(about);
                break;
        }
    }
}
