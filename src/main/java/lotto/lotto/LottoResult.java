package lotto.lotto;

import lotto.enums.PrizeEnum;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<PrizeEnum, Integer> result = new HashMap<>();

    public int count(PrizeEnum prizeEnum) {
        return getOrDefault(prizeEnum);
    }

    public void increaseCount(int matchingCount, boolean matchBonus) {
        if (matchingCount < PrizeEnum.FIFTH.matchingCount()) {
            return;
        }
        PrizeEnum prizeEnum = PrizeEnum.valueOf(matchingCount, matchBonus);
        int count = getOrDefault(prizeEnum);
        result.put(prizeEnum, ++count);
    }

    public int income() {
        int total = 0;
        for (PrizeEnum prizeValue : PrizeEnum.values()) {
            total += prizeValue.income(this);
        }
        return total;
    }

    private int getOrDefault(PrizeEnum prizeEnum) {
        return result.getOrDefault(prizeEnum, 0);
    }
}
