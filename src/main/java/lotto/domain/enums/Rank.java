package lotto.domain.enums;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch < FIFTH.countOfMatch) {
            return MISS;
        }

        if (countOfMatch == 5 && matchBonus) {
            return SECOND;
        }

        if (countOfMatch == 5 && !matchBonus) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(value -> value.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Rank 입니다."));
    }

    @Override
    public String toString() {
        return countOfMatch + "개 일치" +
                (this == SECOND ? ", 보너스 볼 일치" : "") +
                "(" + winningMoney + "원)";
    }

    public static Rank from(String rank) {
        return Arrays.stream(values())
                .filter(value -> value.name().equals(rank))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Rank 입니다."));
    }
}