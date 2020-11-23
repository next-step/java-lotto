package humbledude.lotto.domain;

import java.util.stream.Stream;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BLANK(0, false, 0);

    private final int matchedCount;
    private final boolean checkBonus;
    private final long prize;

    LottoPrize(int matchedConut, boolean checkBonus, long prize) {
        this.matchedCount = matchedConut;
        this.checkBonus = checkBonus;
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isCheckBonus() {
        return checkBonus;
    }

    public static LottoPrize of(int matchedCount, boolean bonusMatched) {
        return Stream.of(LottoPrize.values())
                .filter(prize -> prize.getMatchedCount() == matchedCount && (!prize.checkBonus || bonusMatched))
                .findFirst()
                .orElse(BLANK);
    }
}
