package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtistInfoActivity extends AppCompatActivity {
    //Variables
    TextView textSongName;
    TextView textSongArtist;
    ImageView imgSongImage;
    Button toPlayerButton;
    static String songName;
    static String songArtist;
    static int songImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistinfo);
        //Get Intent stored data
        Intent i = getIntent();

        songName = i.getStringExtra("songName");
        songArtist = i.getStringExtra("songArtist");
        songImage = i.getIntExtra("songImage", R.drawable.ic_player_central_icon);

        textSongName = findViewById(R.id.songName);
        textSongArtist = findViewById(R.id.songArtist);
        imgSongImage = findViewById(R.id.songImage);

        if(songName == null){
            textSongName.setText(R.string.emptySoundMessage);
        }else{
            textSongName.setText(songName);
            textSongArtist.setText(songArtist);
            imgSongImage.setImageResource(songImage);
            TextView songDescription = findViewById(R.id.song_description);
            songDescription.setText(R.string.songDescription);
        }

        //Created a button for go to Player

        toPlayerButton = findViewById(R.id.toPlayerButton);

        toPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toPlayer = new Intent(ArtistInfoActivity.this, MainActivity.class);
                startActivity(toPlayer);
            }
        });

    }
}
