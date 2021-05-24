package lotto.lotto;

import lotto.enums.PrizeEnum;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> result = new HashMap<>();

    public int count(int matchingCount) {
        return getOrDefault(matchingCount);
    }

    public void increaseCount(int matchingCount) {
        int count = getOrDefault(matchingCount);
        result.put(matchingCount, ++count);
    }

    public int income() {
        int total = 0;
        for (PrizeEnum prizeValue : PrizeEnum.values()) {
            total += prizeValue.income(this);
        }
        return total;
    }

    private int getOrDefault(int matchingCount) {
        return result.getOrDefault(matchingCount, 0);
    }
}
