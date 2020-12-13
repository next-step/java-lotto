package com.jaenyeong.mission02.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private static final int MAX_NUMBERS_OF_LOTTERY = 6;
    private final Set<LotteryNumber> lotteryNumbers;

    public LotteryNumbers() {
        lotteryNumbers = new TreeSet<>(Comparator.comparingInt(LotteryNumber::getLotteryNumber));
        generateLotteryNumbersAutomatically();
    }

    private void generateLotteryNumbersAutomatically() {
        final List<Integer> existNumbers = new ArrayList<>();

        while (lotteryNumbers.size() < MAX_NUMBERS_OF_LOTTERY) {
            final LotteryNumber lotteryNumber = LotteryNumber.of(existNumbers);

            existNumbers.add(lotteryNumber.getLotteryNumber());
            lotteryNumbers.add(lotteryNumber);
        }
    }

    protected List<Integer> getLotteryNumbers() {
        return lotteryNumbers.stream()
            .map(LotteryNumber::getLotteryNumber)
            .collect(Collectors.toList());
    }
}
