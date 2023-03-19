package lotto;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum Winner {
    FIRST(6, 2000000000,FALSE,0),
    SECOND(5, 30000000,TRUE,0),
    THIRD(5, 1500000,FALSE,0),
    FOURTH(4, 50000,FALSE,0),
    FIFTH(3, 5000,FALSE,0);

    private final int matchCount;
    private final int prize;
    private final boolean bonus;
    private int winnerCount;

    Winner(int matchCount, int prize, boolean bonus, int winnerCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.bonus = bonus;
    }

    public void setWinnerCount(){
        this.winnerCount = this.winnerCount + 1;
    }

    public int getWinnerCount() {
        return winnerCount;
    }

    public int getMatchCount(){
        return matchCount;
    }

    public int getPrize(){
        return prize;
    }

    public boolean isBonus() {
        return bonus;
    }
}
