package com.jaenyeong.mission02.lotto.domain.lottery;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class LotteryNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final Map<Integer, LotteryNumber> LOTTERY_NUMBER_POOL;
    private static final List<LotteryNumber> LOTTERY_NUMBER_LIST;
    private static final int START_OF_RANGE = 0;
    private static final String ERR_TEXT_INVALID_NUMBER = "[error] This number is not valid.";

    private final int lotteryNumber;

    static {
        LOTTERY_NUMBER_POOL = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .boxed()
            .collect(toMap(Function.identity(), LotteryNumber::new));

        LOTTERY_NUMBER_LIST = new ArrayList<>(LOTTERY_NUMBER_POOL.values());
    }

    private LotteryNumber(final int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    private static LotteryNumber getFlyweightLotteryNumber(final int key) {
        return Optional.ofNullable(LOTTERY_NUMBER_POOL.get(key))
            .orElseThrow(() -> new IllegalArgumentException(ERR_TEXT_INVALID_NUMBER));
    }

    // lazy initialize
//    private static LotteryNumber getFlyweightLotteryNumber(final int key) {
//        return LOTTERY_NUMBER_POOL.computeIfAbsent(key, LotteryNumber::new);
//    }

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
