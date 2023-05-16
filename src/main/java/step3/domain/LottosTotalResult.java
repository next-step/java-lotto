package step3.domain;

import java.util.HashMap;
import java.util.Map;

public class LottosTotalResult {

    private final Map<Rank, Integer> resultMap = new HashMap<>();

    public LottosTotalResult() {
        for (Rank result : Rank.values()) {
            resultMap.put(result, 0);
        }
    }

    public void plusOne(int numberOfMatched, boolean matchBonus) {
        Rank rank = Rank.resultOf(numberOfMatched, matchBonus);
        resultMap.put(rank, resultMap.get(rank) + 1);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Rank rank : Rank.values()) {
            totalPrice += resultMap.get(rank) * rank.winningPrice;
        }
        return totalPrice;
    }

    public double getRateOfReturn(int purchasedPrice) {
        return (double) getTotalPrice() / purchasedPrice;
    }

    public Integer get(Rank rank) {
        return resultMap.get(rank);
    }
}
