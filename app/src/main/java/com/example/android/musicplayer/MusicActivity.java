package com.example.android.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Locale;

import static com.example.android.musicplayer.MainActivity.songArtistArr;
import static com.example.android.musicplayer.MainActivity.songImageArr;
import static com.example.android.musicplayer.MainActivity.songNameArr;

public class MusicActivity extends AppCompatActivity {
    //Declaration of Variables
    private SongAdapter adapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Create a list of songs

        ArrayList<Song> songs = new ArrayList<Song>();

        for (int i = 0; i < songNameArr.length; i++){
            Song sng = new Song(songNameArr[i], songArtistArr[i], songImageArr[i]);
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
