package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    NOTHING(2, (count, bonus) -> count < 2, 0),
    FIFTH(3, (count, bonus) -> count == 3, 5_000),
    FOURTH(4, (count, bonus) -> count == 4, 50_000),
    THIRD(5, (count, bonus) -> count == 5 && !bonus, 1_500_000),
    SECOND(5, (count, bonus) -> count == 5 && bonus, 30_000_000),
    FIRST(6, (count, bonus) -> count == 6, 2_000_000_000);

    private final int matchedCount;
    private final BiPredicate<Integer, Boolean> matchedCondition;
    private final int prize;

    LottoRank(int matchedCount, BiPredicate<Integer, Boolean> matchedCondition, int prize) {
        this.matchedCount = matchedCount;
        this.matchedCondition = matchedCondition;
        this.prize = prize;
    }

    public static LottoRank prizeByMatchedCount(int matchedCount, boolean bonus) {
        return Arrays.stream(LottoRank.values())
            .filter(rank -> rank.matchedCondition.test(matchedCount, bonus)).findFirst()
            .orElse(NOTHING);
    }

    public int rank(){
        return matchedCount;
    }

    public int prize() {
        return prize;
    }
}

