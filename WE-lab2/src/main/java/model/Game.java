package model;

public class Game {

    private String nameP1;
    private String nameP2;
    private String leader;
    private int round;
    private long startTime;
    private int diceP1;
    private int diceP2;
    private int posP1, oldPosP1;
    private int posP2, oldPosP2;
    private boolean[] isOilArray;
    private boolean over;

    public Game() {
        startTime = System.currentTimeMillis();
        nameP1 = "Super Mario";
        nameP2 = "Super C";
        round = 0;
        
        oldPosP1 = 0;
        oldPosP2 = 0;
        posP1 = 0;
        posP2 = 0;
        
        isOilArray = new boolean[7];
        isOilArray[0] = false;
        isOilArray[1] = false;
        isOilArray[2] = true;
        isOilArray[3] = false;
        isOilArray[4] = false;
        isOilArray[5] = true;
        isOilArray[6] = false;
        
        over = false;
    }
    
    public void getOil() {
        
    }

    public String getPlayer1Name() {
        return nameP1;
    }

    public String getPlayer2Name() {
        return nameP2;
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

    public int getDiceP1() {
        return diceP1;
    }

    public void setDiceP1(int diceP1) {
        this.diceP1 = diceP1;
        this.setPositionP1(this.posP1 + diceP1);
    }

    public int getDiceP2() {
        return diceP2;
    }

    public void setDiceP2(int diceP2) {
        this.diceP2 = diceP2;
        this.setPositionP2(this.posP2 + diceP2);
    }

    public String getLeader() {
        return (posP1 >= posP2) ? nameP1 : nameP2;
    }
    
    public int getOldPositionP1() {
        return oldPosP1;
    }
    
    public int getPositionP1() {
        return posP1;
    }
    
    public void setPositionP1(int newPosition) {
        oldPosP1 = posP1;
        posP1 = newPosition;
        if(newPosition >= isOilArray.length - 1) over = true;
    }
    
    public void resetPositionP1() {
        oldPosP1 = posP1 = 0;
    }
    
    public int getOldPositionP2() {
        return oldPosP2;
    }
    
    public int getPositionP2() {
        return posP2;
    }
    
    public void setPositionP2(int newPosition) {
        oldPosP2 = posP2;
        posP2 = newPosition;
        if(newPosition >= isOilArray.length - 1) over = true;
    }
    
    public void resetPositionP2() {
        oldPosP2 = posP2 = 0;
    }
    
    public boolean isOilField(int position) {
        if(position < isOilArray.length - 1) {
            return isOilArray[position];
        }
        return false;
    }
    
    public boolean isOver() {
        return over;
    }
}
