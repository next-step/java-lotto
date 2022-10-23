package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int countOfMatch;
    private final int winningMoney;

    LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank win(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .map(rank -> checkBonus(rank, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    public int multiply(int countOfMatch) {
        return winningMoney * countOfMatch;
    }

    private static LottoRank checkBonus(LottoRank rank, boolean matchBonus) {
        if (rank.countOfMatch == 5) {
            return rankWithMatchedBonus(matchBonus);
        }
        return rank;
    }

    private static LottoRank rankWithMatchedBonus(boolean matchBonus) {
        if (matchBonus) {
            return SECOND;
        }
        return THIRD;
    }
}
