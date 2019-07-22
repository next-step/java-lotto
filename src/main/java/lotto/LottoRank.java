package lotto;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);

    private int winningMoney;
    private int countOfMatch;

    private LottoRank(int winningMoney, int countOfMatch) {
        this.winningMoney = winningMoney;
        this.countOfMatch = countOfMatch;
    }

    public static LottoRank valueOf(int countOfMatch, boolean isMatchBonus) {
        return Arrays.stream(values())
                     .filter(rank -> rank.countOfMatch == countOfMatch)
                     .findFirst()
                     .map(lottoRank -> applyMatchBonus(lottoRank, isMatchBonus))
                     .orElse(MISS);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    private static LottoRank applyMatchBonus(LottoRank lottoRank, boolean isMatchBonus) {
        if (LottoRank.THIRD == lottoRank && isMatchBonus) {
            return LottoRank.SECOND;
        }

        return lottoRank;
    }
}
