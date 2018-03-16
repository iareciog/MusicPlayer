package com.example.android.musicplayer;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> /*implements Filterable*/{


    private final ArrayList<Song> songs;
    //private SongFilter mFilter;



    public SongAdapter(Activity context, ArrayList<Song> songs){
        super(context, 0, songs);
        this.songs=songs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false );
        }

        Song currentSong = getItem(position);

        if (currentSong != null){
            TextView songTextView = (TextView) listItemView.findViewById(R.id.song_name_text_view);

            if (songTextView != null){
                songTextView.setText(currentSong.getSongName());
            }

            TextView artistTextView = (TextView) listItemView.findViewById(R.id.song_artist_text_view);

            if(artistTextView != null){
                artistTextView.setText(currentSong.getSongArtist());
            }

            ImageView iconView = (ImageView) listItemView.findViewById(R.id.song_image_view);

            if (iconView != null) {
                iconView.setImageResource(R.drawable.ic_music_icon);
            }

        }

        return listItemView;
    }

}
