package lotto.domain;

import java.util.Arrays;
import java.util.Iterator;

public enum Prize {
    FIRST(0, 6, 2000000000, false),
    SECOND(1, 5, 30000000, true),
    THIRD(2, 5, 1500000, false),
    FOURTH(3, 4, 50000, false),
    FIFTH(4, 3, 5000, false);

    private final int index;
    private final int matchingCount;
    private final int money;
    private final boolean matchingBonus;

    Prize(int index, int matchingCount, int prizeMoney, boolean matchingBonus) {
        this.index = index;
        this.matchingCount = matchingCount;
        this.money = prizeMoney;
        this.matchingBonus = matchingBonus;
    }

    public int index() {
        return index;
    }

    public int matchingCount() {
        return matchingCount;
    }

    public int money() {
        return money;
    }

    int winningMoney(int count) {
        return money * count;
    }

    public static Prize valueOf(int matchingCount, boolean matchingBonus) {
        return Arrays.stream(values())
                .filter(p -> matchingCount == p.matchingCount && matchingBonus == p.matchingBonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 값을 가진 Prize는 없습니다." + matchingCount));
    }
}
