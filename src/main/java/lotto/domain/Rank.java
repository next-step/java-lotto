package lotto.domain;

import java.util.stream.Stream;

import static lotto.utils.CommonConstant.*;

public enum Rank {
    FIRST(NUMBER_SIX, false, NUMBER_TWO_BILLION_WON),
    SECOND(NUMBER_FIVE, true, NUMBER_THIRTY_MILLON_WON),
    THIRD(NUMBER_FIVE, false, NUMBER_ONE_POINT_FIVE_MILLION_WON),
    FOURTH(NUMBER_FOUR, false, NUMBER_FIFTY_THOUSAND_WON),
    FIFTH(NUMBER_THREE, false, NUMBER_FIVE_THOUSAND_WON),
    MISS(NUMBER_ZERO, false, NUMBER_ZERO);

    private int countOfMatch;
    private int winningMoney;
    private boolean bonusNumber;

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean getBonusNumber() {
        return bonusNumber;
    }

    Rank(int countOfMatch, boolean bonusNumber, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.bonusNumber = bonusNumber;
        this.winningMoney = winningMoney;
    }


    public static Rank valudOf(int countOfMatch, boolean bonusNumber) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.getCountOfMatch() == countOfMatch)
                .filter(rank -> rank.getBonusNumber() == bonusNumber)
                .findFirst()
                .orElse(Rank.MISS);
    }

}
