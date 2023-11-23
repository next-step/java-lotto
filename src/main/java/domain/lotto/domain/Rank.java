package domain.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000, "6개 일치 (2000000000원)"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5, 1_500_000, "5개 일치 (1500000원)"),
    FOURTH(4, 50_000, "4개 일치 (50000원)"),
    FIFTH(3, 5_000, "3개 일치 (5000원)"),
    MISS(0, 0, "꽝");

    private final int countOfMatch;
    private final int winningMoney;
    private final String description;

    Rank(int countOfMatch, int winningMoney, String description) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.description = description;
    }

    public static Rank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                .filter(o -> o != SECOND)
                .filter(o -> o.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public String getDescription() {
        return description;
    }
}
