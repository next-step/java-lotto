package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Result {
    private final Map<Rank, Integer> result;

    Result() {
        result = new HashMap<>();
    }

    public double getRateOfReturn(Money purchaseMoney) {
        return getProfit().divide(purchaseMoney);
    }

    Money getProfit() {
        int profit = 0;
        for (Rank rank : Rank.values()) {
            profit += rank.getWinningMoney() * getNumOfLotto(rank);
        }
        return new Money(profit);
    }

    public int getNumOfLotto(Rank rank) {
        return result.getOrDefault(
                rank,
                0
        );
    }

    void increaseNumOfLotto(Lotto lotto, Lotto winningLotto, LottoNo bonus) {
        Rank rank = Rank.valueOf(
                lotto.getCountOfMatch(winningLotto)
                , lotto.contains(bonus)
        );
        result.put(
                rank,
                getNumOfLotto(rank) + 1
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result1 = (Result) o;
        return result.equals(result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result.toString());
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
