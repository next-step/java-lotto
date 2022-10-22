package autoLotto;

import static autoLotto.Rank.*;

public class GameResult {
    private double result;
    private int firstRank;
    private int secondRank;
    private int thirdRank;
    private int fourthRank;
    private int fifthRank;

    public GameResult(double result) {
        this.firstRank = FIRST.getCountOfRank();
        this.secondRank = SECOND.getCountOfRank();
        this.thirdRank = THIRD.getCountOfRank();
        this.fourthRank = FOURTH.getCountOfRank();
        this.fifthRank = FIFTH.getCountOfRank();
        this.result = result;
    }

    public int getFirstRank() {
        return firstRank;
    }

    public int getSecondRank() {
        return secondRank;
    }

    public int getThirdRank() {
        return thirdRank;
    }

    public int getFourthRank() {
        return fourthRank;
    }

    public int getFifthRank() {
        return fifthRank;
    }

    public double getResult() {
        return result;
    }
}
