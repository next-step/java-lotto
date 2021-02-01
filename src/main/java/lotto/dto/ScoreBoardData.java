package lotto.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ScoreBoardData {
    private final List<ScoreData> scores;
    private final BigDecimal profit;

    public ScoreBoardData(List<ScoreData> scores, BigDecimal profit) {
        this.scores = scores;
        this.profit = profit;
    }

    public List<ScoreData> getScores() {
        return scores;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreBoardData that = (ScoreBoardData) o;
        return Objects.equals(scores, that.scores) && Objects.equals(profit, that.profit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores, profit);
    }
}
