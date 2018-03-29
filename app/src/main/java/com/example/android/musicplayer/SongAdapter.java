package com.example.android.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class SongAdapter extends BaseAdapter{
    //Variables
    private Context mContext;
    private LayoutInflater inflater;
    private final ArrayList<Song> songs;
    private List<Song> songsList;

    public SongAdapter(Context context, List<Song> songsList){
        mContext = context;
        this.songsList = songsList;
        inflater = LayoutInflater.from(mContext);
        this.songs = new ArrayList<>();
        this.songs.addAll(songsList);
    }

    public class ViewHolder{
        TextView songName;
        TextView songArtist;
        ImageView songImage;
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

    /**
     * Auto-generated Song Adapter for the listView
     *
     * @param position -> position used for explore the ArrayList
     * @param convertView -> convertView used for find and set values
     * @param parent
     *
     * @return adapter view
     **/
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            // Locate the TextViews in list_view.xml;
            holder.songName = convertView.findViewById(R.id.songName);
            holder.songArtist = convertView.findViewById(R.id.songArtist);
            holder.songImage = convertView.findViewById(R.id.SongImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        /*
         * Set the values on a new list
         */
        holder.songName.setText(songsList.get(position).getSongName());
        holder.songArtist.setText(songsList.get(position).getSongArtist());
        holder.songImage.setImageResource(songsList.get(position).getSongImage());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ArtistInfoActivity.class);
                /*
                 * Insert extra data to use it in the intent
                 */
                intent.putExtra("songName",(songsList.get(position).getSongName()));
                intent.putExtra("songArtist",(songsList.get(position).getSongArtist()));
                intent.putExtra("songImage",(songsList.get(position).getSongImage()));
                mContext.startActivity(intent);
            }
        });
        return convertView;
    }

    /**
     * Filter function
     * Search songs on the ArrayList and filter it.
     **/
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
