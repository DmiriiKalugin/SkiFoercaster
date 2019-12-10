package ru.dkalugin.ski_forecaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Button next = (Button) findViewById(R.id.next_activity);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_next_activity = new Intent(Splash.this, First.class);
                startActivity(intent_next_activity);
            }
        });


    }
}
