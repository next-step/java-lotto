package lotto.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 1),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000, 0),
    FIFTH(3, 5_000, 0),
    MISS(0, 0, 0);

    private final int countOfMatch;
    private final int winningMoney;
    private final int bonusCountOfMatch;

    LottoRank(int countOfMatch, int winningMoney, int bonusCountOfMatch) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.bonusCountOfMatch = bonusCountOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getBonusCountOfMatch() {
        return bonusCountOfMatch;
    }

    public static LottoRank valueOf(int countOfMatch, int bonusCountOfMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(value -> value.countOfMatch == countOfMatch && value.bonusCountOfMatch == bonusCountOfMatch)
                .findFirst()
                .orElse(LottoRank.MISS);
    }
}
