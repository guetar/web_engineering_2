package model;

public class Game {

    private String player1Name;
    private String player2Name;
    private int round;
    private long startTime;
    private int dicep1;
    private int dicep2;
    private int leader;

    public Game() {
        player1Name = "Super Mario";
        player2Name = "Super C";
        round = 1;
        startTime = System.currentTimeMillis();
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
    }

    public int getDicep2() {
        return dicep2;
    }

    public void setDicep2(int dicep2) {
        this.dicep2 = dicep2;
    }

    public int getLeader() {
        return leader;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }
}
