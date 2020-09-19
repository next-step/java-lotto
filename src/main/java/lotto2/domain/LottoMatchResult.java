package lotto2.domain;

import lotto2.common.LottoRank;

import java.util.Map;
import java.util.Objects;

/**
 * 역할 - 당첨통계 결과를 반환
 */
public class LottoMatchResult {
    private Map<LottoRank, Integer> matchResult;
    private double profit;

    public LottoMatchResult(Map<LottoRank, Integer> matchResult, double profit) {
        this.matchResult = matchResult;
        this.profit = profit;
    }

    public Map<LottoRank, Integer> getMatchResult() {
        return matchResult;
    }

    public double getProfit() {
        return profit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMatchResult that = (LottoMatchResult) o;
        return Double.compare(that.profit, profit) == 0 &&
                Objects.equals(matchResult, that.matchResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchResult, profit);
    }
}
