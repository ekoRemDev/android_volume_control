package com.example.ben.volumecontrol;

import android.content.Context;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIncrease;
    Button btnDecrease;
    AudioManager audioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Get the AudioManager
        audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
// Set the volume of played media to maximum.
        audioManager.setStreamVolume(AudioManager.STREAM_RING, audioManager.getStreamMaxVolume(AudioManager.STREAM_RING), 0);
//
//
//        audioManager.setRingerMode(AudioManager.RINGER_MODE_SILENT);

        btnIncrease = findViewById(R.id.btnIncrease);
        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Increase", Toast.LENGTH_SHORT).show();

                int ringerMode = audioManager.getRingerMode();
                if (ringerMode==2){
                    Toast.makeText(MainActivity.this, "Ringer Mode Normal", Toast.LENGTH_SHORT).show();
                }else {
                    audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
                }
                
                

            }
        });


        btnDecrease = findViewById(R.id.btnDecrease);
        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Decreased", Toast.LENGTH_SHORT).show();
                audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
            }
        });


    }

}
