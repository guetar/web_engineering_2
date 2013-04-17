package model;


public class Game {

    private String player1Name;
    private String player2Name;
    private int round;
    private int time;
    private int dicep1;
    private int dicep2;
    private int leader;

    public Game() {
        player1Name = "Super Mario";
        player2Name = "Super C";
        round = 1;        
    }
    
    public String getPlayer1Name() {
        return player1Name;
    }

    public void setPlayer1Name(String player1Name) {
        this.player1Name = player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void setPlayer2Name(String player2Name) {
        this.player2Name = player2Name;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
