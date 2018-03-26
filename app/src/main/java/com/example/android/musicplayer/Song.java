package com.example.android.musicplayer;

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
     */

    public Song(String songName, String songArtist, int songImage){
        mSongName = songName;
        mSongArtist = songArtist;
        mSongImage = songImage;
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
     * @return the song image.
     */

    public int getSongImage() { return mSongImage; }

}
