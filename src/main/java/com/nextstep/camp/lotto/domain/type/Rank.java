package com.nextstep.camp.lotto.domain.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    THREE(3, false, 5_000),
    FOUR(4, false, 50_000),
    FIVE(5, false, 1_500_000),
    FIVE_BONUS(5, true, 30_000_000),
    SIX(6, false, 2_000_000_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean hasBonus;
    private final int prize;

    Rank(int matchCount, boolean hasBonus, int prize) {
        this.matchCount = matchCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount && r.hasBonus == hasBonus)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public static List<Rank> getValidValues() {
        return Arrays.stream(values())
                .filter(result -> result != NONE)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%d개 일치%s (%,d원)", matchCount, hasBonus ? ", 보너스 볼 일치" : "", prize);
    }
}
