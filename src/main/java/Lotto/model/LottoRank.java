package Lotto.model;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);


    private int countOfMatch;
    private int winningMoney;

    private LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchedBonus) {
        if (countOfMatch == 5) {
            return matchedBonus ? SECOND : THIRD;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }
}
