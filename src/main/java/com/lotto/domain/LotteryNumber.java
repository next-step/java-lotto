package com.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumber implements Comparable<LotteryNumber> {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private static final List<LotteryNumber> LOTTERY_NUMBER_LIST = IntStream.rangeClosed(START_NUMBER, END_NUMBER)
            .mapToObj(LotteryNumber::new)
            .collect(Collectors.toList());
    private static final List<LotteryNumber> SHUFFLED_LIST = new ArrayList<>(LOTTERY_NUMBER_LIST);
    private final int number;

    private LotteryNumber(int number) {
        this.number = number;
    }

    private static void validateNumber(int number) throws IllegalArgumentException {
        if (number < START_NUMBER || number > END_NUMBER) {
            String message = String.format("%d 이상 %d 이하 숫자만 입력해 주세요.", START_NUMBER, END_NUMBER);
            throw new IllegalArgumentException(message);
        }
    }

    public static LotteryNumber getLotteryNumber(int number) throws IllegalArgumentException {
        validateNumber(number);
        return LOTTERY_NUMBER_LIST.get(number - 1);
    }

    public static LotteryNumber getLotteryNumber(String numberString) throws IllegalArgumentException {
        int number = Integer.parseInt(numberString);
        return getLotteryNumber(number);
    }

    public static Set<LotteryNumber> getLotteryNumbersAutomatically() {
        Collections.shuffle(SHUFFLED_LIST);
        return SHUFFLED_LIST.stream()
                .limit(NUMBER_COUNT)
                .collect(Collectors.toSet());
    }

    @Override
    public int compareTo(LotteryNumber lotteryNumber) {
        return this.number - lotteryNumber.number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
