package com.jaenyeong.mission02.lotto.domain.lottery;

import com.jaenyeong.mission02.lotto.domain.Rank;

import java.util.List;
import java.util.StringJoiner;

public class LotteryGame {
    protected static final int PRICE = 1_000;
    private static final int MISS_MATCH = 0;
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

    public Rank checkWinTheLottery(final LotteryGame otherGame) {
        if (isNotValid(otherGame)) {
            return Rank.valueOf(MISS_MATCH);
        }

        final List<Integer> currentGame = this.lotteryNumbers.getLotteryNumbers();

        currentGame.retainAll(otherGame.getLotteryNumbers());

        return Rank.valueOf(currentGame.size());
    }

    private boolean isNotValid(final LotteryGame otherGame) {
        return (otherGame == null) || (otherGame.getLotteryNumbers().size() == MISS_MATCH);
    }

    protected List<Integer> getLotteryNumbers() {
        return lotteryNumbers.getLotteryNumbers();
    }

    @Override
    public String toString() {
        final StringJoiner stringJoin = new StringJoiner(", ");
        this.getLotteryNumbers().forEach(number -> stringJoin.add(Integer.toString(number)));

        return "[" + stringJoin + "]";
    }
}
