package com.example.celena.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create (this, R.raw.away_from_the_sign);

        Button playButton = (Button) findViewById (R.id.play_button);
        Button pauseButton = (Button) findViewById (R.id.pause_button);

        playButton.setOnClickListener (new View.OnClickListener () {
            public void onClick (View v) {
                mediaPlayer.start ();
            }
        });

        pauseButton.setOnClickListener (new View.OnClickListener () {
            public void onClick (View v) {
                mediaPlayer.pause ();
            }
        });
    }
}
