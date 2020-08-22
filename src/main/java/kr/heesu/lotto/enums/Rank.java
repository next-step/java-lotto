package kr.heesu.lotto.enums;

import java.util.stream.Stream;

public enum Rank {
    MISS(0L, 0L),
    FIFTH(3L, 5_000L),
    FOURTH(4L, 50_000L),
    THIRD(5L, 1_500_000L),
    SECOND(5L, 30_000_000L),
    FIRST(6L, 2_000_000_000L);

    private Long countOfMatch;
    private Long winningMoney;

    Rank(Long countOfMatch, Long winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public Long getCountOfMatch() {
        return countOfMatch;
    }

    public Long getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(Long countOfMatch, boolean matchBonus) {
        if (countOfMatch.equals(SECOND.countOfMatch)) {
            return matchBonus ? SECOND : THIRD;
        }

        return Stream.of(Rank.values())
                .filter(rank -> rank.countOfMatch.equals(countOfMatch))
                .findFirst()
                .orElse(MISS);
    }
}
