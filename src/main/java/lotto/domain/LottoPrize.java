package lotto.domain;

import java.util.Arrays;

public enum LottoPrize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    SIXTH(2, false, 0),
    SEVENTH(1, false, 0),
    EIGHTH(0, false, 0);

    private int matchCount;

    private boolean matchBonus;

    private int prize;

    LottoPrize(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoPrize getEnumNameByIntValue(int matchCount, boolean matchBonus) throws IllegalArgumentException {
        return Arrays.stream(LottoPrize.values())
                .filter(prize -> ((prize.matchCount == matchCount) && (prize.matchBonus == matchBonus)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("해당 카운트는 없음 : %d", matchCount)));
    }

    public int getPrize() {
        return prize;
    }
}
