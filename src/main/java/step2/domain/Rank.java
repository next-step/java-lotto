package step2.domain;

import java.util.Arrays;

import static step2.domain.Money.ZERO_MONEY;

public enum Rank {

    FIRST(6, new Money(2_000_000_000)),
    SECOND(5, new Money(30_000_000)),
    THIRD(5, new Money(1_500_000)),
    FOURTH(4, new Money(50_000)),
    FIFTH(3, new Money(5_000)),
    MISS(0, ZERO_MONEY);

    private final int correctCount;

    private final Money winningMoney;

    Rank(int correctCount, Money winningMoney) {
        this.correctCount = correctCount;
        this.winningMoney = winningMoney;
    }

    public Money getWinningMoney() {
        return winningMoney;
    }

    public int getWinningMoneyNumber() {
        return winningMoney.getValue();
    }


    public int getCorrectCount() {
        return correctCount;
    }

    public static Rank valueOf(int correctCount) {
        return Arrays.stream(values()).filter(rank -> rank.correctCount == correctCount)
                .findFirst().orElse(MISS);
    }
}
