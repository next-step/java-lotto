package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class Result {
    private final HashMap<Integer, Integer> result;

    public Result(List<Lotto> lottos, Lotto winningLotto) {
        result = new HashMap<>();
        for (Lotto lotto : lottos) {
            int count = lotto.countSameNo(winningLotto);
            increaseNumOfLotto(count);
        }
    }

    public Money getProfit() {
        int profit = 0;
        for (Jackpot jackpot : Jackpot.values()) {
            profit += jackpot.getPrizeMoney() * getNumOfLotto(jackpot);
        }
        return new Money(profit);
    }

    public int getNumOfLotto(Jackpot jackpot) {
        return getNumOfLotto(
                jackpot.getNumOfCorrected()
        );
    }

    private int getNumOfLotto(int numOfCorrected) {
        return Optional.ofNullable(
                result.get(numOfCorrected)
        ).orElseGet(() -> 0);
    }

    void increaseNumOfLotto(int numOfCorrected) {
        result.put(
                numOfCorrected,
                getNumOfLotto(numOfCorrected) + 1
        );
    }
}
