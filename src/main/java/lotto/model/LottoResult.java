package lotto.model;

public class LottoResult {

    private final ScoreMap scoreMap;
    private final int totalReward;
    private final int expense;

    public ScoreMap getScoreMap() {
        return scoreMap;
    }

    public int getTotalReward() {
        return totalReward;
    }

    public int getExpense() {
        return expense;
    }

    public LottoResult(ScoreMap scoreMap, int totalReward, int expense) {
        this.scoreMap = scoreMap;
        this.totalReward = totalReward;
        this.expense = expense;
    }
}
