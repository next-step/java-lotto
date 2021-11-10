package lotto.service.domain.types;

import java.util.Arrays;

import static lotto.rule.LottoRule.LOTTO_SECOND_MATCH_COUNT;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank convertRankByCountOfMatch(int countOfMatch, boolean matchBonus) {
        if (isSecond(countOfMatch, matchBonus)) {
            return Rank.SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> Rank.SECOND != rank)
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findAny()
                .orElse(MISS);
    }

    private static boolean isSecond(int countOfMatch, boolean matchBonus) {
        return LOTTO_SECOND_MATCH_COUNT == countOfMatch && matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
