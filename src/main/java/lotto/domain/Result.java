package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private final Map<Integer, Integer> result;

    public Result(List<Lotto> lottos, Lotto winningLotto) {
        result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int count = lotto.countSameNo(winningLotto);
            increaseNumOfLotto(count);
        }
    }

    public double getRateOfReturn(Money purchaseMoney) {
        return getProfit().divide(purchaseMoney);
    }

    public Money getProfit() {
        int profit = 0;
        for (Jackpot jackpot : Jackpot.values()) {
            profit += jackpot.getPrizeMoney() * getNumOfLotto(jackpot);
        }
        return new Money(profit);
    }

    public int getNumOfLotto(Jackpot jackpot) {
        return result.getOrDefault(
                jackpot.getNumOfCorrected(),
                0
        );
    }

    private void increaseNumOfLotto(int numOfCorrected) {
        result.put(
                numOfCorrected,
                result.getOrDefault(numOfCorrected, 0) + 1
        );
    }
}
