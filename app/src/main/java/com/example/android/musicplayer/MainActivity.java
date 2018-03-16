package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean isPlay = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView previousButton = (ImageView) findViewById(R.id.previous_button);
        ImageView rewindButton = (ImageView) findViewById(R.id.rewind_button);
        final ImageView playStopButton = (ImageView) findViewById(R.id.playStop_button);
        ImageView forwardButton = (ImageView) findViewById(R.id.forward_button);
        ImageView nextButton = (ImageView) findViewById(R.id.next_button);
        ImageView songListButton = (ImageView) findViewById(R.id.songList_button);
        ImageView artistInfoButton = (ImageView) findViewById(R.id.artistInfo_button);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rewindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        playStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(isPlay){
                        playStopButton.setImageResource(R.drawable.ic_stop_icon);
                        isPlay = false;
                    }else{
                        playStopButton.setImageResource(R.drawable.ic_play_icon);
                        isPlay = true;
                    }
            }
        });

        forwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        songListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(songListIntent);
            }
        });

        artistInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(MainActivity.this, ArtistInfoActivity.class);
                startActivity(searchButtonIntent);
            }
        });

    }




}
