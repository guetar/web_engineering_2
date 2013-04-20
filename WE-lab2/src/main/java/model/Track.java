package model;

/**
 *
 * @author guetar
 */
public class Track {

    private boolean[] track;
    
    public Track() {
        track = new boolean[7];
        track[0] = false;
        track[1] = false;
        track[2] = true;
        track[3] = false;
        track[4] = false;
        track[5] = true;
        track[6] = false;
    }
    
    public int getLength() {
        return track.length - 1;
    }
}
