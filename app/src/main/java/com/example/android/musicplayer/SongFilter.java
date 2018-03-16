package com.example.android.musicplayer;

import android.util.Log;
import android.widget.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SongFilter /*extends Filter*/ {


}

   /* private SongAdapter songAdapter;

    public SongFilter(SongAdapter songAdapter){
        this.songAdapter = songAdapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint){
        constraint = constraint.toString().toLowerCase();
        FilterResults results = new FilterResults();
        ArrayList<Song> filterList = new ArrayList<Song>();
        if(constraint != null && constraint.toString().length() > 0){
            ArrayList<Song> originalList = new ArrayList<Song>(
                    songAdapter.getValuesSong());

            for (Song s : originalList){
                if (s.getSongName().toLowerCase().contains(constraint))
                    filterList.add(new Song(s.getSongName(), s.getSongArtist()));
            }
            Log.i("DEBUG", originalList.toString());
            results.values = filterList;
            results.count = filterList.size();
        }else{
            results.values = songAdapter.getValuesSong();
            results.values = songAdapter.getValuesSong().size();
        }
        return results;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void publishResults(CharSequence constraint, FilterResults results){
        ArrayList<Song> filterSongs = (ArrayList<Song>) results.values;
        songAdapter.clear();
        for (Iterator<Song> i = filterSongs.iterator(); i.hasNext();){
            Song s = i.next();
            songAdapter.addValuesSongs(s);
        }
    }
}
*/