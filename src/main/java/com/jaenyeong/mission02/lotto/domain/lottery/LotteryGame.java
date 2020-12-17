package com.jaenyeong.mission02.lotto.domain.lottery;

import java.util.List;
import java.util.StringJoiner;

public class LotteryGame {
    protected static final int PRICE = 1_000;
    private static final int MISS_MATCH = 0;
    private static final String DELIMITER = ", ";
    private final LotteryNumbers lotteryNumbers;

    private LotteryGame(final LotteryNumbers lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LotteryGame ofAuto() {
        return new LotteryGame(LotteryNumbers.ofAuto());
    }

    public static LotteryGame ofManual(final List<Integer> givenNumbers) {
        return new LotteryGame(LotteryNumbers.ofManual(givenNumbers));
    }

    public static int howManyBuyGame(final int money) {
        return money / PRICE;
    }

    public boolean containBonusNumber(final int bonusNumber) {
        return this.lotteryNumbers.containsBonusNumber(bonusNumber);
    }

    public int matchWinningNumber(final LotteryGame winningNumbers) {
        if (isNotValid(winningNumbers)) {
            return MISS_MATCH;
        }

        return this.lotteryNumbers.matchWinningNumbers(winningNumbers.lotteryNumbers);
    }

    private boolean isNotValid(final LotteryGame winningNumbers) {
        return (winningNumbers == null) || (winningNumbersSize(winningNumbers) == MISS_MATCH);
    }

    private int winningNumbersSize(final LotteryGame winningNumbers) {
        return winningNumbers.lotteryNumbers
            .getLotteryNumbersSize();
    }

    protected List<Integer> getLotteryNumbers() {
        return lotteryNumbers.getLotteryNumbers();
    }

    @Override
    public String toString() {
        final StringJoiner stringJoin = new StringJoiner(DELIMITER);
        this.getLotteryNumbers().forEach(number -> stringJoin.add(Integer.toString(number)));

        return "[" + stringJoin + "]";
    }
}
