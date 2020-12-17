package com.jaenyeong.mission02.lotto.domain.lottery;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LotteryNumber {
    private static final Map<Integer, LotteryNumber> LOTTERY_NUMBER_POOL = new HashMap<>();
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final List<LotteryNumber> LOTTERY_NUMBER_LIST = generateLotteryNumbers();
    private static final int START_OF_RANGE = 0;
    private static final String ERR_TEXT_INVALID_NUMBER = "[error] This number is not valid.";

    private final int lotteryNumber;

    private LotteryNumber(final int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    private static List<LotteryNumber> generateLotteryNumbers() {
        return IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .mapToObj(LotteryNumber::getFlyweightLotteryNumber)
            .collect(toList());
    }

    private static LotteryNumber getFlyweightLotteryNumber(final int givenNumber) {
        final LotteryNumber lotteryNumber = LOTTERY_NUMBER_POOL.get(givenNumber);
        if (lotteryNumber != null) {
            return lotteryNumber;
        }

        final LotteryNumber newLotteryNumber = new LotteryNumber(givenNumber);
        LOTTERY_NUMBER_POOL.put(givenNumber, newLotteryNumber);
        return newLotteryNumber;
    }

    public static Set<LotteryNumber> ofAutoNumbers(final int endOfRange) {
        Collections.shuffle(LOTTERY_NUMBER_LIST);
        final Set<LotteryNumber> lotteryNumbers = new TreeSet<>(Comparator.comparingInt(LotteryNumber::getLotteryNumber));
        lotteryNumbers.addAll(LOTTERY_NUMBER_LIST.subList(START_OF_RANGE, endOfRange));

        return lotteryNumbers;
    }

    public static LotteryNumber ofManual(final int givenNumber) {
        if ((START_NUMBER <= givenNumber) && (givenNumber <= END_NUMBER)) {
            return getFlyweightLotteryNumber(givenNumber);
        }

        throw new IllegalArgumentException(ERR_TEXT_INVALID_NUMBER);
    }

    public int getLotteryNumber() {
        return lotteryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryNumber that = (LotteryNumber) o;
        return getLotteryNumber() == that.getLotteryNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLotteryNumber());
    }
}
