package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
    }

    public Map<Rank, Integer> result() {
        return result;
    }

    public void update(int matchCount) {
        if (3 <= matchCount && matchCount <= 6) {
            result.replace(Rank.rankByMatchCount(matchCount),
                result.get(Rank.rankByMatchCount(matchCount)) + 1);
        }
    }

    private int totalPrice() {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> element : result.entrySet()) {
            totalPrize += element.getValue() * element.getKey().prizeAmount();
        }
        return totalPrize;
    }

    public long rateOfReturn(int money) {
        return (long) this.totalPrice() / money * 100;
    }
}
