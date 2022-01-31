package domain;

import java.util.Arrays;

public enum Rank {
    FAIL(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private final int prize;
    private final int matchCount;

    Rank(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public static Rank getRank(int matchCount, Lotto lotto, int bonusNumber) {
        if (matchCount == 5) {
            return checkBonusRank(lotto, bonusNumber);
        }
        return Arrays.stream(Rank.values())
                .filter(prize -> prize.isMatchCount(matchCount))
                .findFirst()
                .orElse(FAIL);
    }

    private static Rank checkBonusRank(Lotto lotto, int bonusNumber) {
        if (lotto.checkBonusNumber(bonusNumber)) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    private boolean isMatchCount(int mathCount) {
        return this.matchCount == mathCount;
    }
}
