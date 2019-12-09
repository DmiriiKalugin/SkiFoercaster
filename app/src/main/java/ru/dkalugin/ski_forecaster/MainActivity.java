package ru.dkalugin.ski_forecaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.next_activity);
        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent_next_activity = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent_next_activity);
            }
        });


    }
}
