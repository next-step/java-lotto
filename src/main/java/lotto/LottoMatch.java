package lotto;

import java.util.Arrays;

public enum LottoMatch {
    NONE(0, 0),
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    public final int matchCount;
    public final int prize;

    LottoMatch(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoMatch fromMatchCount(int matchCount) {
        return Arrays.stream(values())
                .filter(match -> match.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%,d원)", matchCount, prize);
    }
}
