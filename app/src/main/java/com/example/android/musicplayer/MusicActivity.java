package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

public class MusicActivity extends AppCompatActivity {

    private ArrayList<Song> songs;
    private SongAdapter adapter;
    private EditText editText;
    String[] songName;
    String[] songArtist;
    int[] songImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        songName = new String [] {"song", "1song", "2song", "3song"};
        songArtist = new String[] {"artist", "artist3", "artist3", "artist2"};
        songImage = new int[] {R.drawable.ic_music_icon, R.drawable.ic_music_icon, R.drawable.ic_music_icon, R.drawable.ic_music_icon};

        //Create a list of songs

        songs = new ArrayList<Song>();

        for (int i = 0; i < songName.length; i++){
            Song sng = new Song(songName[i], songArtist[i]);
            songs.add(sng);
        }

        adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.search_list_view);

        listView.setAdapter(adapter);

        editText = (EditText) findViewById(R.id.searchView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String text = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
