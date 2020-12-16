package com.jaenyeong.mission02.lotto.domain.lottery;

import com.jaenyeong.mission02.lotto.domain.Rank;

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

    public Rank checkWinTheLotteryWithBonus(final LotteryGame userGame, final int bonusNumber) {
        if (isNotValid(userGame)) {
            return Rank.valueOf(MISS_MATCH);
        }

        final List<Integer> userGameNumbers = userGame.lotteryNumbers.getLotteryNumbers();
        final boolean bonusMatch = userGameNumbers.contains(bonusNumber);

        userGameNumbers.retainAll(this.lotteryNumbers.getLotteryNumbers());

        return Rank.valueOf(userGameNumbers.size(), bonusMatch);
    }

    private boolean isNotValid(final LotteryGame otherGame) {
        return (otherGame == null) || (otherGame.getLotteryNumbers().size() == MISS_MATCH);
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
