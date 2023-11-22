package lotto.domain;

import java.util.Arrays;

public class PrizeSelector {
    public static Prize selectByCount(int matchingCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isSameCount(matchingCount))
                .findFirst()
                .orElse(Prize.NOTHING);
    }
}
