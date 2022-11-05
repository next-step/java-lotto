package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum WinningAccordance {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NONE(0, 0, false),
    ;

    private final int matchCount;
    private final int prize;
    private final boolean matchBonus;

    WinningAccordance(int matchCount, int prize, boolean matchBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.matchBonus = matchBonus;
    }

    public static WinningAccordance of(Accordance accordance) {
        return Arrays.stream(values())
            .filter(winningAccordance -> winningAccordance.matchCount == accordance.getCountSameNumbers())
            .filter(winningAccordance -> winningAccordance.matchBonus == accordance.containsBonusNumber())
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
