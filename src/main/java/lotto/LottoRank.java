package lotto;

import java.util.Arrays;

public enum LottoRank {
    MISS(0,0),
    FOURTH(5_000, 3 ),
    THIRD(50_000, 4),
    SECOND(1_500_000, 5),
    FIRST(2_000_000_000, 6);

    private int winningMoney;
    private int countOfMatch;

    private LottoRank(int winningMoney, int countOfMatch) {
        this.winningMoney = winningMoney;
        this.countOfMatch = countOfMatch;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch) {
        return Arrays.stream(values())
                    .filter(rank -> rank.countOfMatch == countOfMatch)
                    .findFirst()
                    .orElse(MISS);
    }
}
