package model;

import java.util.*;

public class Game {

    private String player1Name;
    private String player2Name;
    private int round;
    private long startTime;
    private int dicep1;
    private int dicep2;
    private int leader;
    private int posP1;
    private int posP2;
    private boolean[] isOilArray;

    public Game() {
        player1Name = "Super Mario";
        player2Name = "Super C";
        round = 0;
        posP1=0;
        posP2=0;
        
        startTime = System.currentTimeMillis();
        isOilArray = new boolean[7];
        isOilArray[0] = isOilArray[1] = isOilArray[3] = isOilArray[4] = isOilArray[6] = false;
        isOilArray[5] = isOilArray[2] = true;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public int getRound() {
        return round;
    }

    public void incrementRound() {
        round++;
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public int getDicep1() {
        return dicep1;
    }

    public void setDicep1(int dicep1) {
        this.dicep1 = dicep1;
        this.setPositionP1(this.posP1+dicep1);
    }

    public int getDicep2() {
        return dicep2;
    }

    public void setDicep2(int dicep2) {
        this.dicep2 = dicep2;
        this.setPositionP2(this.posP2+dicep2);
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }
    
    public int getPositionP1() {
        return posP1;
    }
    
    public void setPositionP1(int newPosition) {
        posP1 = newPosition;
    }
    
    public int getPositionP2() {
        return posP1;
    }
    
    public void setPositionP2(int newPosition) {
        posP2 =newPosition;
    }
    
    public boolean isOilField(int position) {
        if(position < isOilArray.length) {
            return isOilArray[position];
        }
        return false;
    }
}
