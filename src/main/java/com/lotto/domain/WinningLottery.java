package com.lotto.domain;

import java.util.Set;

public class WinningLottery {

    private static final int NUMBER_COUNT = 6;
    private final Set<LotteryNumber> winningLotteryNumbers;
    private final LotteryNumber bonusLotteryNumber;

    public WinningLottery(Set<LotteryNumber> winningLotteryNumbers, LotteryNumber bonusLotteryNumber) {
        validateLotteryNumbers(winningLotteryNumbers);
        validateBonusLotteryNumbers(winningLotteryNumbers, bonusLotteryNumber);
        this.winningLotteryNumbers = winningLotteryNumbers;
        this.bonusLotteryNumber = bonusLotteryNumber;
    }

    private void validateLotteryNumbers(Set<LotteryNumber> lotteryNumbers) throws IllegalArgumentException {
        if (lotteryNumbers.size() != NUMBER_COUNT) {
            String message = String.format("%d 개의 숫자만 입력해 주세요.", NUMBER_COUNT);
            throw new IllegalArgumentException(message);
        }
    }

    private void validateBonusLotteryNumbers(Set<LotteryNumber> lotteryNumbers, LotteryNumber bonusLotteryNumber)
            throws IllegalArgumentException {
        if (lotteryNumbers.contains(bonusLotteryNumber)) {
            String message = "보너스 숫자는 기존 숫자 외 숫자가 필요합니다.";
            throw new IllegalArgumentException(message);
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
