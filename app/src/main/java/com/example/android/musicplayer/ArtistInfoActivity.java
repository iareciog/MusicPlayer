package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistInfoActivity extends AppCompatActivity {
    /**
     * Declare variables
     */

    TextView textSongName;
    TextView textSongArtist;
    ImageView imgSongImage;
    static String songName;
    static String songArtist;
    static int songImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistinfo);

        Intent i = getIntent();

        songName = i.getStringExtra("songName");
        songArtist = i.getStringExtra("songArtist");
        songImage = i.getIntExtra("songImage", R.drawable.ic_player_central_icon);

        textSongName = findViewById(R.id.songName);
        textSongArtist = findViewById(R.id.songArtist);
        imgSongImage = findViewById(R.id.songImage);

        if(songName == null && songArtist == null){
            textSongName.setText(R.string.emptySoundMessage);
        }else{
            textSongName.setText(songName);
            textSongArtist.setText(songArtist);
            imgSongImage.setImageResource(songImage);
            TextView songDescription = findViewById(R.id.song_description);
            songDescription.setText(R.string.songDescription);
        }

    }
}
