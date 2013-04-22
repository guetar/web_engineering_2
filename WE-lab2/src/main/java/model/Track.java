package model;

import java.util.Arrays;

/**
 *
 * @author guetar
 */
public class Track {

    private boolean[] track;
    private String[] bez;

    public Track() {
        
        bez = new String[8];
        bez[0] = "start_road";
        bez[1] = "road_1";
        bez[2] = "road_2";
        bez[3] = "road_3";
        bez[4] = "road_4";
        bez[5] = "road_5";
        bez[6] = "finish_road";
       
        track = new boolean[7];
        Arrays.fill(track, Boolean.FALSE);
        track[2] = true;
        track[5] = true;
    }

    public boolean getOil(int position) {
        return track[position];
    }

    public int getLength() {
        return track.length;
    }
    
    public String getPosName(int pos) {
        return bez[pos];
    }
}
