package com.example.android.musicplayer;

public class Song {

    /** Song Name */
    private String mSongName;

    /** Song Artist */
    private String mSongArtist;

    /*
        Create a new Music object.

        @param song -> is the song name.
        @param artist -> is the song artist name.
     */

    public Song(String SongName, String SongArtist){
        mSongName = SongName;
        mSongArtist = SongArtist;
    }

    /**
     * @return the song name.
     **/

    public String getSongName(){ return mSongName; }

    /**
     * @return the song artist name.
     **/

    public String getSongArtist() { return mSongArtist; }

}
