package ru.dkalugin.ski_forecaster.ski_forecaster;




import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ru.dkalugin.ski_forecaster.R;
import ru.dkalugin.ski_forecaster.condition.Arcificial;
import ru.dkalugin.ski_forecaster.condition.Crude;
import ru.dkalugin.ski_forecaster.condition.Fresh;
import ru.dkalugin.ski_forecaster.condition.Old;

public class   SkiForecaster extends AppCompatActivity  implements View.OnClickListener{

    private static final String PREFERENCE_NAME = "System.io";
    private static int value = 1;
    private static int value_min = 5;
    SharedPreferences preferences;
    String run_more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ski_forecaster);

        preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(PREFERENCE_NAME, value);
        editor.apply();

        int sp = preferences.getInt(PREFERENCE_NAME, 0);
        if (sp <=5){
            int attempts = value_min - value;
            if (attempts == 1){
                run_more =  "Можно запустить ещё " + attempts + " раз";
            }
            else if (attempts == 0){
                run_more = "Это последний запуск на этой неделе";
            }
            else {
                run_more = "Можно запустить ещё " + attempts + " раза";
            }

            Toast.makeText(this, run_more, Toast.LENGTH_LONG).show();
            value++;
        }
        else {
            finish();
            value = 1;
            Toast.makeText(this, "Лимит исчерпан", Toast.LENGTH_LONG).show();
        }


        Button btn_fresh = (Button) findViewById(R.id.btn_fresh);
        Button btn_old = (Button) findViewById(R.id.btn_old);
        Button btn_crude = (Button) findViewById(R.id.btn_crude);
        Button btn_artificial = (Button) findViewById(R.id.btn_artificial);

        btn_fresh.setOnClickListener(this);
        btn_old.setOnClickListener(this);
        btn_crude.setOnClickListener(this);
        btn_artificial.setOnClickListener(this);

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

        if (air_temperature.getText().toString().equals(""))
        {
            openSiteDialog();

        }
        else
        {
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


}
