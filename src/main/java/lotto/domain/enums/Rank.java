package lotto.domain.enums;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5,30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0),
    ;

    private final long matchCount;
    private final int winningBonus;

    Rank(long matchCount, int winningBonus) {
        this.matchCount = matchCount;
        this.winningBonus = winningBonus;
    }

    public static Rank of(Long matchCount, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .filter(rank -> !rank.equals(SECOND) | bonusMatch)
                .findFirst()
                .orElse(MISS);
    }

    public static Stream<Rank> getLottoBoardMatcher() {
        return Stream.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public long getMatchCount() {
        return matchCount;
    }

    public int getWinningBonus() {
        return winningBonus;
    }
}
