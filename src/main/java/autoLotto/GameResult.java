package autoLotto;

import static autoLotto.Match.*;

public class GameResult {

    private int threeMatch;
    private int fourMatch;
    private int fiveMatch;
    private int sixMatch;
    private double result;

    public GameResult(double result) {
        this.threeMatch = THREE.getCountOfMatch();
        this.fourMatch = FOUR.getCountOfMatch();
        this.fiveMatch = FIVE.getCountOfMatch();
        this.sixMatch = SIX.getCountOfMatch();
        this.result = result;
    }

    public int getThreeMatch() {
        return threeMatch;
    }

    public int getFourMatch() {
        return fourMatch;
    }

    public int getFiveMatch() {
        return fiveMatch;
    }

    public int getSixMatch() {
        return sixMatch;
    }

    public double getResult() {
        return result;
    }
}
