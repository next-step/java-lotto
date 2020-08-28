package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class LottoMatchResult {

    private Map<Integer, Integer> matchResult;
    private double profit;

    public LottoMatchResult(Map<Integer, Integer> matchResult, double profit) {
        this.matchResult = matchResult;
        this.profit = profit;
    }

    public int getMatchTicketCount(int matchCount) {
        return matchResult.getOrDefault(matchCount, 0);
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoMatchResult that = (LottoMatchResult) o;
        return Double.compare(that.profit, profit) == 0 &&
              Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResult, profit);
    }
}
