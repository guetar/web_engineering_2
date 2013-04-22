package model;

/**
 *
 * @author guetar
 */
public class Player {
    
    private String name;
    private Track track;
    private int dice;
    private int oldPos;
    private int curPos;
    
    public Player(String name, Track track) {
        this.name = name;
        this.track = track;
        this.oldPos = 0;
        this.curPos = 0;
        this.dice = 0;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setTrack(Track track) {
        this.track = track;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }
    
    public int getDice() {
        return dice;
    }
    
    public void setPos(int newPos) {
        oldPos = curPos;
        curPos = newPos;
    }
    
    public int getOldPos() {
        return oldPos;
    }
    
    public int getCurPos() {
        return curPos;
    }
    
    public String getOPos() {
        return track.getPosName(oldPos);
    }
    
    public String getNPos() {
        return track.getPosName(curPos);
    }
}