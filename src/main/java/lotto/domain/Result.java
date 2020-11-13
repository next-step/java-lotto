package lotto.domain;

import java.util.HashMap;
import java.util.Optional;

public class Result {
    private HashMap<Jackpot, Integer> result;

    protected Result() {
        result = new HashMap<>();
    }

    public int getNumOfLotto(Jackpot jackpot) {
        return Optional.ofNullable(result.get(jackpot)).orElseGet(() -> 0);
    }

    protected void increaseNumOfLotto(Jackpot jackpot) {
        result.put(
                jackpot,
                getNumOfLotto(jackpot) + 1
        );
    }

    protected Money getProfit() {
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
