package com.lotto.domain;

import java.util.Set;

public class WinningLottery {

    private static final int NUMBER_COUNT = 6;
    private final Set<LotteryNumber> winningLotteryNumbers;
    private final LotteryNumber bonusLotteryNumber;

    public WinningLottery(Set<LotteryNumber> winningLotteryNumbers, LotteryNumber bonusLotteryNumber) {
        validateLotteryNumbers(winningLotteryNumbers, bonusLotteryNumber);
        this.winningLotteryNumbers = winningLotteryNumbers;
        this.bonusLotteryNumber = bonusLotteryNumber;
    }

    private void validateLotteryNumbers(Set<LotteryNumber> lotteryNumbers, LotteryNumber bonusLotteryNumber)
            throws IllegalArgumentException {
        if (lotteryNumbers.size() != NUMBER_COUNT || lotteryNumbers.contains(bonusLotteryNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public Rank matchRank(Lottery lottery) {
        int matchingCount = (int) winningLotteryNumbers.stream()
                .filter(lottery::hasLotteryNumber)
                .count();
        boolean matchingBonus = lottery.hasLotteryNumber(bonusLotteryNumber);
        return Rank.matchRank(matchingCount, matchingBonus);
    }
}
