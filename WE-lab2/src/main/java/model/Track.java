package model;

/**
 *
 * @author guetar
 */
public class Track {

    private boolean[] track;

    public Track() {
        track = new boolean[7];
        track[2] = true;
        track[5] = true;
    }

    public boolean getOil(int position) {
        return track[position];
    }

    public int getLength() {
        return track.length;
    }
}
