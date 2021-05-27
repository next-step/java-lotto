package lotto.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import lotto.enums.Prize;

public class LottoResult {
    private final Map<Prize, Integer> result = new HashMap<>();

    public int count(Prize prize) {
        return result.getOrDefault(prize, 0);
    }

    public void increaseCount(int matchingCount, boolean matchBonus) {
        if (isFail(matchingCount)) {
            return;
        }
        Prize prize = Prize.valueOf(matchingCount, matchBonus);
        int count = count(prize);
        result.put(prize, ++count);
    }

    public int income() {
        return Stream.of(Prize.values())
                .mapToInt(prize -> prize.income(this))
                .sum();
    }

    private boolean isFail(int matchingCount) {
        return matchingCount < Prize.FIFTH.matchingCount();
    }
}
