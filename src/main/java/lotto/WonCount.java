package lotto;

public class WonCount {
    private int wonCount=0;

    public void updateCount(boolean isWon) {
        if(isWon)
            wonCount++;
    }

    public int getWonCount() {
        return wonCount;
    }
}
