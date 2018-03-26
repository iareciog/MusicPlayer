package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//Import static variables for compare if exist a song.
import static com.example.android.musicplayer.ArtistInfoActivity.songName;
import static com.example.android.musicplayer.ArtistInfoActivity.songArtist;
import static com.example.android.musicplayer.ArtistInfoActivity.songImage;

public class MainActivity extends AppCompatActivity {
    //Declared variables
    static String[] songNameArr;
    static String[] songArtistArr;
    static int[] songImageArr;

    boolean isPlay = false;
    ImageView playStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Created 3 arrays with the info in every position

        songNameArr = new String [] {"song", "1song", "2song", "3song"};
        songArtistArr = new String[] {"artist", "artist3", "artist3", "artist2"};
        songImageArr = new int[] {R.drawable.ic_music_icon, R.drawable.ic_music_icon, R.drawable.ic_music_icon, R.drawable.ic_music_icon};

        //Get the objects used in this program.

        ImageView previousButton = (ImageView) findViewById(R.id.previous_button);
        ImageView rewindButton = (ImageView) findViewById(R.id.rewind_button);
        playStopButton = (ImageView) findViewById(R.id.playStop_button);
        ImageView forwardButton = (ImageView) findViewById(R.id.forward_button);
        ImageView nextButton = (ImageView) findViewById(R.id.next_button);
        ImageView songListButton = (ImageView) findViewById(R.id.songList_button);
        ImageView songListButtonNoSearch = (ImageView) findViewById(R.id.artistInfo_button);

        /*
         * Check if songName and SongArtist aren't equal to null
         * and get the song data, changes the player playStop image
         * and sets the song data on their TextViews
         */

        if(songName != null && songArtist != null){
            TextView songNameText = (TextView) findViewById(R.id.songName);
            TextView songArtistText = (TextView) findViewById(R.id.songArtist);
            ImageView songImageImg = (ImageView) findViewById(R.id.songImage);

            playStopButton.setImageResource(R.drawable.ic_stop_icon);

            songNameText.setText(songName);
            songArtistText.setText(songArtist);
            songImageImg.setImageResource(songImage);
        }

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
                //Simple play/stop switch for this player prototype (non functional for a real music player)
                if(isPlay){
                    isPlay = false;
                    playStopButton.setImageResource(R.drawable.ic_stop_icon);
                } else {
                    isPlay = true;
                    playStopButton.setImageResource(R.drawable.ic_play_icon);
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

        /*
         * Start the MusicListActivity activity
         * Shows a list of songs.
         */

        songListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent songListIntent = new Intent(MainActivity.this, MusicListActivity.class);
                startActivity(songListIntent);
            }
        });

        /*
         * Start the MusicActivity activity
         * Shows a list of songs with search.
         */

        songListButtonNoSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent searchButtonIntent = new Intent(MainActivity.this, MusicActivity.class);
                startActivity(searchButtonIntent);
            }
        });
    }
}

