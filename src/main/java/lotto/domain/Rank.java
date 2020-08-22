package lotto.domain;

import java.util.stream.Stream;

import static lotto.utils.CommonConstant.*;

public enum Rank {
    FIRST(NUMBER_SIX, NUMBER_TWO_BILLION_WON),
    SECOND(NUMBER_FIVE, NUMBER_ONE_POINT_FIVE_MILLION_WON),
    THIRD(NUMBER_FOUR, NUMBER_FIFTY_THOUSAND_WON),
    FOURTH(NUMBER_THREE, NUMBER_FIVE_THOUSAND_WON),
    LOSING(NUMBER_ZERO, NUMBER_ZERO);

    private int countOfMatch;
    private int winningMoney;

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valudOf(int countOfMatch) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .findFirst()
                .orElse(Rank.LOSING);
    }

}
