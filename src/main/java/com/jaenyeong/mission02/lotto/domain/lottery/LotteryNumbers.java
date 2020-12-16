package com.jaenyeong.mission02.lotto.domain.lottery;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryNumbers {
    private static final int MAX_NUMBERS_OF_LOTTERY = 6;
    private static final String ERR_TEXT_INVALID_NUMBERS = "[error] This number list is not valid.";
    private final Set<LotteryNumber> lotteryNumbers;

    private LotteryNumbers(final Set<LotteryNumber> lotteryNumbers) {
        this.lotteryNumbers = lotteryNumbers;
    }

    public static LotteryNumbers ofAuto() {
        final Set<LotteryNumber> lotteryNumbers = LotteryNumber.ofAutoNumbers(MAX_NUMBERS_OF_LOTTERY);

        return new LotteryNumbers(lotteryNumbers);
    }

    protected List<Integer> getLotteryNumbers() {
        return lotteryNumbers.stream()
            .map(LotteryNumber::getLotteryNumber)
            .collect(Collectors.toList());
    }

    public static LotteryNumbers ofManual(final List<Integer> givenNumbers) {
        final Set<Integer> uniqueNumbers = new HashSet<>(givenNumbers);
        if (uniqueNumbers.size() != MAX_NUMBERS_OF_LOTTERY) {
            throw new IllegalArgumentException(ERR_TEXT_INVALID_NUMBERS);
        }

        final Set<LotteryNumber> lotteryNumbers = uniqueNumbers.stream()
            .map(LotteryNumber::ofManual)
            .collect(Collectors.toCollection(
                () -> new TreeSet<>(Comparator.comparingInt(LotteryNumber::getLotteryNumber))
            ));

        return new LotteryNumbers(lotteryNumbers);
    }
}
