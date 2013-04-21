package model;

public class Game {

    private Player p1;
    private Player p2;
    private Track track;
    private int leader;
    private boolean gameOver;
    private int round;
    private long startTime;

    public Game() {
        startTime = System.currentTimeMillis();
        track = new Track();
        
        p1 = new Player("Super Mario", track);
        p2 = new Player("Super C", track);
    }
    
    public Track getTrack() {
        return track;
    }
    
    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
        p1.setTrack(track);
    }

    public void setP2(Player p2) {
        this.p2 = p2;
        p2.setTrack(track);
    }

    public void incrementRound() {
        round++;
    }

    public int getRound() {
        return round;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    
    public String getLeader() {
        if(leader == 1) {
            return p1.getName();
        } else if(leader == 2) {
            return p2.getName();
        } else {
            return "";
        }
    }
    
    public void setLeader(int leader) {
        this.leader = leader;
    }
    
    public boolean isOilField(int position) {
        if (position < track.getLength() - 1) {
            return track.getOil(position);
        }
        
        return false;
    }

    public boolean isOver() {
        return gameOver;
    }
    
    public void setOver() {
        gameOver = true;
    }
}
