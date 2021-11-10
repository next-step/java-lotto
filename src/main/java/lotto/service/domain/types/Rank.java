package lotto.service.domain.types;

import java.util.Arrays;

import static lotto.rule.LottoRule.LOTTO_SECOND_MATCH_COUNT;

public enum Rank {
    FIRST(6, 2_000_000_000, 5),
    SECOND(5, 30_000_000, 4),
    THIRD(5, 1_500_000, 3),
    FOURTH(4, 50_000, 2),
    FIFTH(3, 5_000, 1),
    MISS(0, 0, 0);

    private final int countOfMatch;
    private final int winningMoney;
    private final int sort;

    Rank(int countOfMatch, int winningMoney, int sort) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.sort = sort;
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

    public int getSort() {
        return sort;
    }
}
