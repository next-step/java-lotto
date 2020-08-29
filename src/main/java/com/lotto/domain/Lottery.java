package com.lotto.domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Lottery {

    private static final int NUMBER_COUNT = 6;
    private final Set<LotteryNumber> lotteryNumbers;

    public Lottery(Set<LotteryNumber> lotteryNumbers) throws IllegalArgumentException {
        validateLotteryNumbers(lotteryNumbers);
        this.lotteryNumbers = lotteryNumbers;
    }

    private void validateLotteryNumbers(Set<LotteryNumber> lotteryNumbers) throws IllegalArgumentException {
        if (lotteryNumbers.size() != NUMBER_COUNT) {
            String message = String.format("%d 개의 숫자만 입력해 주세요.", NUMBER_COUNT);
            throw new IllegalArgumentException(message);
        }
    }

    public boolean hasLotteryNumber(LotteryNumber lotteryNumber) {
        return lotteryNumbers.contains(lotteryNumber);
    }

    @Override
    public String toString() {
        return this.lotteryNumbers.stream()
                .sorted()
                .map(LotteryNumber::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
