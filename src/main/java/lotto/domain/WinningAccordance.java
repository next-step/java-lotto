package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningAccordance {

    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000),
    NONE(0, 0),
    ;

    private final int matchCount;
    private final int prize;

    WinningAccordance(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static WinningAccordance of(long matchCount) {
        return Arrays.stream(values())
                .filter(winningAccordance -> winningAccordance.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static List<WinningAccordance> validValues() {
        return Arrays.stream(values())
                .filter(WinningAccordance::isValid)
                .collect(Collectors.toList());
    }

    private boolean isValid() {
        return this != NONE;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
