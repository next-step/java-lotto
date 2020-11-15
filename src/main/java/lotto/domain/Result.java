package lotto.domain;

import java.util.HashMap;
import java.util.Optional;

public class Result {
    private final HashMap<Jackpot, Integer> result;

    Result() {
        result = new HashMap<>();
    }

    public int getNumOfLotto(Jackpot jackpot) {
        return Optional.ofNullable(result.get(jackpot)).orElseGet(() -> 0);
    }

    void increaseNumOfLotto(Jackpot jackpot) {
        result.put(
                jackpot,
                getNumOfLotto(jackpot) + 1
        );
    }

    Money getProfit() {
        int profit = 0;
        for (Jackpot jackpot : Jackpot.values()) {
            profit += jackpot.getPrizeMoney() * getNumOfLotto(jackpot);
        }
        return new Money(profit);
    }

    public double getRateOfReturn(Money purchaseMoney) {
        return getProfit().divide(purchaseMoney);
    }
}
