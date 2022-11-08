package lotto.domain;

public class GameResult {

    private RankCount rankCount;
    private double result;

    public GameResult(RankCount rankCount, double result) {
        this.rankCount = rankCount;
        this.result = result;
    }

    public RankCount rankCount() {
        return rankCount;
    }

    public double result() {
        return result;
    }
}
