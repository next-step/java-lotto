package lotto.dto;

import java.util.List;
import java.util.Objects;

public class ScoreBoardData {
    private final List<ScoreData> scores;
    private final double profit;

    public ScoreBoardData(List<ScoreData> scores, double profit) {
        this.scores = scores;
        this.profit = profit;
    }

    public List<ScoreData> getScores() {
        return scores;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoardData that = (ScoreBoardData) o;
        return Double.compare(that.profit, profit) == 0 && Objects.equals(scores, that.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores, profit);
    }
}
