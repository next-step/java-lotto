package com.jaenyeong.mission02.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private static final int MAX_NUMBERS_OF_LOTTERY = 6;
    private final Set<LotteryNumber> lotteryNumbers;

    private LotteryNumbers(final Set<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LotteryNumbers ofAuto() {
        final List<Integer> existNumbers = new ArrayList<>();
        final Set<LotteryNumber> lotteryNumbers = new TreeSet<>(Comparator.comparingInt(LotteryNumber::getLotteryNumber));

        while (existNumbers.size() < MAX_NUMBERS_OF_LOTTERY) {
            final LotteryNumber lotteryNumber = LotteryNumber.ofAuto(existNumbers);

            existNumbers.add(lotteryNumber.getLotteryNumber());
            lotteryNumbers.add(lotteryNumber);
        }

        return new LotteryNumbers(lotteryNumbers);
    }

    protected List<Integer> getLotteryNumbers() {
        return lotteryNumbers.stream()
            .map(LotteryNumber::getLotteryNumber)
            .collect(Collectors.toList());
    }
}
