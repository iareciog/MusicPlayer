package com.example.android.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Create a list of songs

        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("song", "artist", R.drawable.ic_music_icon));
        songs.add(new Song("1song1", "artist", R.drawable.ic_music_icon));
        songs.add(new Song("2song2", "2artist2", R.drawable.ic_music_icon));
        songs.add(new Song("3song3", "3artist3", R.drawable.ic_music_icon));
        songs.add(new Song("4song4", "artist", R.drawable.ic_music_icon));
        songs.add(new Song("5song5", "2artist2", R.drawable.ic_music_icon));
        songs.add(new Song("6song6", "artist", R.drawable.ic_music_icon));
        songs.add(new Song("7song7", "1artist1", R.drawable.ic_music_icon));
        songs.add(new Song("8song8", "1artist1", R.drawable.ic_music_icon));
        songs.add(new Song("9song9", "artist", R.drawable.ic_music_icon));
        songs.add(new Song("10song10", "1artist1", R.drawable.ic_music_icon));


        final SongAdapter adapter = new SongAdapter(this, songs);

        final ListView listView = (ListView) findViewById(R.id.search_list_view);

        listView.setAdapter(adapter);

        final EditText searchView = (EditText) findViewById(R.id.searchView);

        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                ArrayList<Song> matches = new ArrayList<Song>();
                // MI IMPLEMENTACION PARA SACAR ALGO GRACIAS A STACKOVERFLOW
                for (Song song: songs){
                    if (song.getSongName().contains(searchView.getText().toString())) {
                        Log.i("Song Name IS TRUE", song.getSongName());
                        matches.add(new Song(song.getSongName(), song.getSongArtist(), song.getSongImage()));
                    }else{
                        Log.i("Song Name IS FALSE", song.getSongName());
                    }
                }
                for(int i=0; i < matches.size(); i++){
                    Log.i("SEE_ARRAYLIST_CONTENT:", matches.get(i).toString());
                }
                listView.setAdapter(adapter);

                //FIN DE IMPLEMENTACION
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(MusicActivity.this, ArtistInfoActivity.class);
                startActivity(intent);
            }
        });

    }
}
