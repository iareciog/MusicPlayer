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
import static com.example.android.musicplayer.MainActivity.songs;

public class MusicActivity extends AppCompatActivity {
    //Variables
    private SongAdapter adapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Create a list of songs

        adapter = new SongAdapter(this, songs);

        ListView listView = findViewById(R.id.search_list_view);

        listView.setAdapter(adapter);

        editText = findViewById(R.id.searchView);

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
