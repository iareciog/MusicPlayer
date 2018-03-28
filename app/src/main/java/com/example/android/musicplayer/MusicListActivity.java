package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.android.musicplayer.MainActivity.songArtistArr;
import static com.example.android.musicplayer.MainActivity.songImageArr;
import static com.example.android.musicplayer.MainActivity.songNameArr;

public class MusicListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_list);

        ArrayList<Song> songs = new ArrayList<>();

        for (int i = 0; i < songNameArr.length; i++){
            Song sng = new Song(songNameArr[i], songArtistArr[i], songImageArr[i]);
            songs.add(sng);
        }

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.search_list_view);

        listView.setAdapter(adapter);

    }
}
