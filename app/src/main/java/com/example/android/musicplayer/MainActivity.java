package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Import static variables for compare if exist a song.

import static com.example.android.musicplayer.ArtistInfoActivity.songName;
import static com.example.android.musicplayer.ArtistInfoActivity.songArtist;
import static com.example.android.musicplayer.ArtistInfoActivity.songImage;

public class MainActivity extends AppCompatActivity {
    //Declared variables
    static String[] songNameArr;
    static String[] songArtistArr;
    static int[] songImageArr;
    static ArrayList<Song> songs;
    private int songPos;
    private ImageView songImageImg;
    private TextView songArtistText;
    private TextView songNameText;

    private boolean isPlay = false;
    private ImageView playStopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Created 3 arrays with the info in every position

        songNameArr = new String[]{"song", "1song", "2song", "3song"};
        songArtistArr = new String[]{"artist", "artist3", "artist3", "artist2"};
        songImageArr = new int[]{R.drawable.ic_music_icon, R.drawable.ic_music_icon, R.drawable.ic_music_icon, R.drawable.ic_music_icon};

        //Get the objects used in this program.

        ImageView previousButton = findViewById(R.id.previous_button);
        ImageView rewindButton = findViewById(R.id.rewind_button);
        playStopButton = findViewById(R.id.playStop_button);
        ImageView forwardButton = findViewById(R.id.forward_button);
        ImageView nextButton = findViewById(R.id.next_button);
        ImageView songListButton = findViewById(R.id.songList_button);
        ImageView songListButtonNoSearch = findViewById(R.id.artistInfo_button);

        songNameText = findViewById(R.id.songName);
        songArtistText = findViewById(R.id.songArtist);
        songImageImg = findViewById(R.id.songImage);

        songs = new ArrayList<>();

        for (int i = 0; i < songNameArr.length; i++) {
            Song sng = new Song(songNameArr[i], songArtistArr[i], songImageArr[i]);
            songs.add(sng);
        }

        /*
         * Check if songName and SongArtist aren't equal to null
         * and get the song data, changes the player playStop image
         * and sets the song data on their TextViews
         */

        if (songName != null) {
            playStopButton.setImageResource(R.drawable.ic_stop_icon);

            songNameText.setText(songName);
            songArtistText.setText(songArtist);
            songImageImg.setImageResource(songImage);

            songPos = getSongPos();
        }

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (songName != null) {
                    if(songPos - 1 >= 0){
                        songPos = songPos - 1;
                    }else{
                        songPos = 0;
                    }
                    if (songPos > 0) {
                        songName = songNameArr[songPos];
                        songArtist = songArtistArr[songPos];
                        songImage = songImageArr[songPos];
                    } else {
                        songPos = 0;
                        songName = songNameArr[0];
                        songArtist = songArtistArr[0];
                        songImage = songImageArr[0];
                    }
                    songNameText.setText(songName);
                    songArtistText.setText(songArtist);
                    songImageImg.setImageResource(songImage);
                }
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
                if (isPlay) {
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
                if (songName != null) {
                    if(songPos + 1 < getArrayLength()){
                        songPos = songPos + 1;
                    }
                    songName = songNameArr[songPos];
                    songArtist = songArtistArr[songPos];
                    songImage = songImageArr[songPos];
                }
                songNameText.setText(songName);
                songArtistText.setText(songArtist);
                songImageImg.setImageResource(songImage);
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
    private int getSongPos() {
        int pos = 0;
        for (int i = 0; i < songNameArr.length; i++) {
            if (songNameArr[i].matches(songName)) {
                pos = i;
            }
        }
        return pos;
    }

    private int getArrayLength(){ return songNameArr.length; }
}

