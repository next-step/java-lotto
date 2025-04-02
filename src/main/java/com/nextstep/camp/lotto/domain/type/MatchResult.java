package com.nextstep.camp.lotto.domain.type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MatchResult {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    MatchResult(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static MatchResult of(int matchCount) {
        return Arrays.stream(values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }

    public static List<MatchResult> getValidValues() {
        return Arrays.stream(values())
                .filter(result -> result != NONE)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, prize);
    }
}
