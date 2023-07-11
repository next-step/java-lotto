package lottogame.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoPrize {

    FIRST(6, MagicNumberSupporter.BONUS_NOT_RELATED, 2_000_000_000),
    SECOND(5, MagicNumberSupporter.BONUS_RELATED, 30_000_000),
    THIRD(5, MagicNumberSupporter.BONUS_NOT_RELATED, 1_500_000),
    FORTH(4, MagicNumberSupporter.BONUS_NOT_RELATED, 50_000),
    FIFTH(3, MagicNumberSupporter.BONUS_NOT_RELATED, 5_000),
    NONE(0, MagicNumberSupporter.BONUS_NOT_RELATED, 0),
    ;

    private final int matchedCount;
    private final boolean isBonusMatched;
    private final int money;

    LottoPrize(int matchedCount, boolean isBonusMatched, int money) {
        if (!isBonusMatched) {
            ConstructorSupporter.LOTTO_PRIZE_CONVERTOR.put(matchedCount, this);
        }
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.money = money;
    }

    public static LottoPrize of(int matchedCount, boolean isBonusMatched) {
        if (matchedCount == MagicNumberSupporter.SECOND_PRIZE_MATCHED_COUNT && isBonusMatched) {
            return SECOND;
        }

        return ConstructorSupporter.LOTTO_PRIZE_CONVERTOR.getOrDefault(matchedCount, NONE);
    }

    public int getMoney() {
        return money;
    }

    private static final class MagicNumberSupporter {

        private static final boolean BONUS_NOT_RELATED = false;
        private static final boolean BONUS_RELATED = true;
        private static final int SECOND_PRIZE_MATCHED_COUNT = 5;

    }

    private static final class ConstructorSupporter {

        private static final Map<Integer, LottoPrize> LOTTO_PRIZE_CONVERTOR = new HashMap<>();
    }
}
