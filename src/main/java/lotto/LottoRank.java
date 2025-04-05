package lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false,1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    public final int matchCount;
    public final boolean isBonusMatch;
    public final int prize;

    LottoRank(int matchCount, boolean isBonusMatch, int prize) {
        this.matchCount = matchCount;
        this.isBonusMatch = isBonusMatch;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoRank fromMatchCount(int matchCount, boolean isBonusMatch) {
        return Arrays.stream(values())
                .filter(match -> match.matchCount == matchCount && match.isBonusMatch == isBonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    @Override
    public String toString() {
        String bonusText = isBonusMatch ? ", 보너스 볼 일치" : "";
        return String.format("%d개 일치%s (%,d원)", matchCount, bonusText, prize);
    }
}
