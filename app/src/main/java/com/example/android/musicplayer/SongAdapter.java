package com.example.android.musicplayer;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SongAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater inflater;
    private final ArrayList<Song> songs;
    private List<Song> songsList = null;

    public SongAdapter(Context context, List<Song> songsList){
        mContext = context;
        this.songsList = songsList;
        inflater = LayoutInflater.from(mContext);
        this.songs = new ArrayList<Song>();
        this.songs.addAll(songsList);
    }

    public class ViewHolder{
        TextView songName;
        TextView songArtist;
    }

    @Override
    public int getCount(){
        return songsList.size();
    }

    @Override
    public Song getItem(int position){
        return songsList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            // Locate the TextViews in list_view.xml;
            holder.songName = (TextView) convertView.findViewById(R.id.songName);
            holder.songArtist = (TextView) convertView.findViewById(R.id.songArtist);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.songName.setText(songsList.get(position).getSongName());
        holder.songArtist.setText(songsList.get(position).getSongArtist());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ArtistInfoActivity.class);

                intent.putExtra("songName",(songsList.get(position).getSongName()));
                intent.putExtra("songArtist",(songsList.get(position).getSongArtist()));
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    //Filter class
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        songsList.clear();
        if(charText.length() == 0){
            songsList.addAll(songs);
        }else{
            for (Song sng: songs){
                if (sng.getSongName().toLowerCase(Locale.getDefault()).contains(charText)){
                    songsList.add(sng);
                }
            }
        }
        notifyDataSetChanged();
    }

}
