package lotto.domain;

import java.util.Arrays;

public enum LottoResult {

    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000),
    FAIL(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoResult(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static LottoResult findResult(int matchCount, boolean matchBonus) {
        LottoResult result = Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(LottoResult.FAIL);

        if (result == LottoResult.FIVE && matchBonus) {
            return BONUS;
        }

        return result;
    }

    public int matchCount() {
        return this.matchCount;
    }
    public boolean matchBonus() {
        return this.matchBonus;
    }

    public int prize() {
        return this.prize;
    }
}
