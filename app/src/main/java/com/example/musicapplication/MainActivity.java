package com.example.musicapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPause, btnPlay, btnStop;

        btnPlay = findViewById(R.id.playbtn);
        btnPause = findViewById(R.id.pausebtn);
        btnStop = findViewById(R.id.stopbtn);


        MediaPlayer mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

        String aPath = "android.resource://"+getPackageName()+"/raw/shri_krishna";

        Uri audioURI = Uri.parse(aPath);
        try {
            mp.setDataSource(this, audioURI);
            mp.prepare();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                Toast.makeText(MainActivity.this, "Song Paused Successfully", Toast.LENGTH_SHORT).show();
            }

        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                Toast.makeText(MainActivity.this, "Song Played Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
                Toast.makeText(MainActivity.this, "Song Stop Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}