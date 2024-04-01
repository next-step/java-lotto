package lotto.domain;

import java.util.Arrays;
import java.util.Objects;

public enum WinningType {
    LOOSE(0, 0, false),
    HIT_COUNT_3(3, 5_000L, false),
    HIT_COUNT_4(4, 50_000L, false),
    HIT_COUNT_5(5, 1_500_000L, false),
    HIT_COUNT_5_AND_BONUS(5, 3_000_000L, true),
    HIT_COUNT_6(6, 2_000_000_000L, false);

    private final long hitCount;
    private final long revenue;
    private final boolean matchBonus;

    public long getHitCount() {
        return hitCount;
    }

    public long getRevenue() {
        return revenue;
    }

    public boolean isMatchBonus() {
        return matchBonus;
    }

    public boolean is2ndBonusWinner() {
        return this == HIT_COUNT_5_AND_BONUS;
    }

    WinningType(long hitCount, long revenue, boolean matchBonus) {
        this.hitCount = hitCount;
        this.revenue = revenue;
        this.matchBonus = matchBonus;
    }


    public static WinningType valueOf(long hitCount, boolean matchBonus) {
        return Arrays.stream(WinningType.values())
                .filter(it -> Objects.equals(it.hitCount, hitCount))
                .filter(it -> Objects.equals(it.matchBonus, matchBonus))
                .findFirst()
                .orElse(WinningType.LOOSE);
    }
}
