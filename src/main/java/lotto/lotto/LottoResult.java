package lotto.lotto;

import lotto.enums.PrizeEnum;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> matchAnswer = new HashMap<>();

    public int count(int answer) {
        return getOrDefault(answer);
    }

    public void increaseCount(int answer) {
        int count = getOrDefault(answer);
        matchAnswer.put(answer, ++count);
    }

    public int income() {
        int total = 0;
        for (PrizeEnum prizeValue : PrizeEnum.values()) {
            total += prizeValue.income(this);
        }
        return total;
    }

    private int getOrDefault(int answer) {
        return matchAnswer.getOrDefault(answer, 0);
    }
}
