package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class ArtistInfoActivity extends AppCompatActivity {
    //Declare variables
    TextView textSongName;
    TextView textSongArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistinfo);

        Intent i = getIntent();

        String songName = i.getStringExtra("songName");

        String songArtist = i.getStringExtra("songArtist");

        textSongName = (TextView) findViewById(R.id.songName);
        textSongArtist = (TextView) findViewById(R.id.songArtist);

        textSongName.setText(songName);
        textSongArtist.setText(songArtist);
    }
}
