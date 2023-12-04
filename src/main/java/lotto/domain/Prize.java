package lotto.domain;

import java.util.Arrays;

import static lotto.domain.Money.ZERO_MONEY;

public enum Prize {

    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(1_500_000)),
    THIRD(4, new Money(50_000)),
    FOURTH(3, new Money(5_000)),
    MISS(0, ZERO_MONEY);

    private final int correctCount;

    private final Money winningMoney;

    Prize(int correctCount, Money winningMoney) {
        this.correctCount = correctCount;
        this.winningMoney = winningMoney;
    }

    public static Prize valueOf(int correctCount) {
        return Arrays.stream(values()).filter(rank -> rank.correctCount == correctCount)
                .findFirst().orElse(MISS);
    }

    public boolean isCanGetPrizeRank() {
        return this != MISS;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public int getWinningMoneyNumber() {
        return winningMoney.intValue();
    }


    public int getCorrectCount() {
        return correctCount;
    }

}
