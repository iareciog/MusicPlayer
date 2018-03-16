package com.example.android.musicplayer;

import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;

public class Song {

    /** Song Name */
    private String mSongName;

    /** Song Artist */
    private String mSongArtist;

    /** Song Image */

    private int mSongImage;

    /*
        Create a new Music object.

        @param song -> is the song name.
        @param artist -> is the song artist name.
        @param image -> is the song image.
     */

    public Song(String SongName, String SongArtist, int SongImage){
        mSongName = SongName;
        mSongArtist = SongArtist;
        mSongImage = SongImage;
    }

    /**
     * @return the song name.
     **/

    public String getSongName(){ return mSongName; }

    /**
     * @return the song artist name.
     **/

    public String getSongArtist() { return mSongArtist; }

    /**
     * @return the song Image.
     **/

    public int getSongImage() { return mSongImage; };

}
