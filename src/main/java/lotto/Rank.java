package lotto;


import java.util.Arrays;
import lotto.MatchResult;

public enum Rank {
    FIRST(6, false, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, true, 30_000_000, "5개 일치, 보너스 볼 일치(30000000원)"),
    THIRD(5, false, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, false, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, false, 5_000, "3개 일치 (5000원)"),
    NONE(0, false, 0, "낙첨");

    private final int matchCount;
    private final boolean bonusRequired;
    private final int prize;
    private final String label;

    Rank(int matchCount, boolean bonusRequired, int prize, String label) {
        this.matchCount = matchCount;
        this.bonusRequired = bonusRequired;
        this.prize = prize;
        this.label = label;
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

    public String label() {
        return label;
    }
}
