package lotto.model;

public class LottoResult {

    private final ScoreMap scoreMap;
    private final int expense;

    public ScoreMap getScoreMap() {
        return scoreMap;
    }

    public int getExpense() {
        return expense;
    }

    public LottoResult(ScoreMap scoreMap, int expense) {
        this.scoreMap = scoreMap;
        this.expense = expense;
    }
}
