package lotto;


import java.util.Arrays;
import lotto.MatchResult;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;

    Rank(int matchCount, boolean bonusRequired, int prize) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
    }

    public static Rank of(MatchResult result) {
        return Arrays.stream(values())
            .filter(rank -> rank.isMatch(result))
            .findFirst()
            .orElse(NONE);
    }

    private boolean isMatch(MatchResult result) {
        if (result.matchCount() != matchCount) {
            return false;
        }
        if (!bonusRequired) {
            return true;
        }
        return result.isBonusMatched();
    }

    public int prize() {
        return prize;
    }

    public int matchCount() {
        return matchCount;
    }
}
