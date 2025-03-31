package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {

    FIRST_PLACE(6, 2_000_000_000, false),
    SECOND_PLACE_WITH_BONUS(5, 3_000_000, true),
    SECOND_PLACE(5, 1_500_000, false),
    THIRD_PLACE(4, 50_000, false),
    FOURTH_PLACE(3, 5_000, false),
    NONE(0, 0, false);

    private final int matchCount;
    private final int prize;
    private final boolean requiresBonusNumber;

    LottoPrize(int matchCount, int prize, boolean requiresBonusNumber) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonusNumber = requiresBonusNumber;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static LottoPrize valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static LottoPrize valueOf(int matchCount, boolean hasBonusNumber) {
        if (matchCount == FIRST_PLACE.matchCount){
            return FIRST_PLACE;
        }
        if (matchCount == SECOND_PLACE_WITH_BONUS.matchCount && hasBonusNumber){
            return SECOND_PLACE_WITH_BONUS;
        }
        if (matchCount == SECOND_PLACE.matchCount) {
            return SECOND_PLACE;
        }
        if (matchCount == THIRD_PLACE.matchCount) {
            return THIRD_PLACE;
        }
        if (matchCount == FOURTH_PLACE.matchCount) {
            return FOURTH_PLACE;
        }
        return NONE;
    }


    public int getPrize() {
        return prize;
    }
}
