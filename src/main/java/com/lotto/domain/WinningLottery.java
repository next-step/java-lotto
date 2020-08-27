package com.lotto.domain;

import java.util.Set;

public class WinningLottery {

    private static final int NUMBER_COUNT = 6;
    private final Set<LotteryNumber> winningLotteryNumbers;

    public WinningLottery(Set<LotteryNumber> winningLotteryNumbers) {
        validateLotteryNumbers(winningLotteryNumbers);
        this.winningLotteryNumbers = winningLotteryNumbers;
    }

    private void validateLotteryNumbers(Set<LotteryNumber> lotteryNumbers) throws IllegalArgumentException {
        if (lotteryNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public Rank matchRank(Lottery lottery) {
        int matchingCount = (int) winningLotteryNumbers.stream()
                .filter(lottery::hasLotteryNumber)
                .count();
        return Rank.matchRank(matchingCount);
    }
}
