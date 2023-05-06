package lotto.domain;

import lotto.exception.PrizeCalculateException;

import java.util.Map;

public enum Prize {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    BOOM(0, 0, false);

    private static final Map<Integer, Prize> MATCH_COUNT_TO_PRIZE_MAPPER = Map.of(
            6, FIRST,
            4, FOURTH,
            3, FIFTH
    );
    private final int matchCount;
    private final int prizeAmount;
    private final boolean bonusNumberMatch;

    Prize(int matchCount, int prizeAmount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public static Prize calculatePrize(int matchCount, boolean containsBonus) {
        if (matchCount < FIFTH.matchCount) {
            return BOOM;
        }
        if (isDetermineMatchCountConditionOnly(matchCount)) {
            return Prize.matchCountToPrize(matchCount);
        }
        if( isConsiderBonusNumber(matchCount)) {
            return Prize.matchCountToPrize(matchCount, containsBonus);
        }
        throw new PrizeCalculateException();
    }

    private static Prize matchCountToPrize(int matchCount, boolean containsBonus) {
        if ((matchCount == THIRD.matchCount) && (containsBonus == THIRD.bonusNumberMatch)) {
            return THIRD;
        }
        if ((matchCount == SECOND.matchCount) && (containsBonus == SECOND.bonusNumberMatch)) {
            return SECOND;
        }
        throw new PrizeCalculateException();
    }

    private static boolean isConsiderBonusNumber(int matchCount) {
        return (matchCount == THIRD.matchCount) || (matchCount == SECOND.matchCount);
    }

    private static Prize matchCountToPrize(int matchCount) {
        if (!MATCH_COUNT_TO_PRIZE_MAPPER.containsKey(matchCount)) {
            throw new PrizeCalculateException();
        }
        return MATCH_COUNT_TO_PRIZE_MAPPER.get(matchCount);
    }

    private static boolean isDetermineMatchCountConditionOnly(int matchCount) {
        return (matchCount == FIFTH.matchCount) || (matchCount == FOURTH.matchCount) || (matchCount == FIRST.matchCount);
    }

    public boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }

    public int calculatePrize(int count) {
        return this.prizeAmount * count;
    }
}
