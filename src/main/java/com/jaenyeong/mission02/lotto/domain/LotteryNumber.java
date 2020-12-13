package com.jaenyeong.mission02.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LotteryNumber {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int RANDOM_VALUE = 0;
    private static final int EXIST = 0;
    private static final int EMPTY = 0;
    public static final String ERR_TEXT_THERE_IS_NOT_NUMBER = "[error] There is no number to choose from list.";
    public static final String ERR_TEXT_INVALID_NUMBER = "[error] This number is not valid.";
    private final int lotteryNumber;

    private LotteryNumber(final int lotteryNumber) {
        this.lotteryNumber = lotteryNumber;
    }

    public static LotteryNumber ofAuto(final List<Integer> numbersThatAlreadyExists) {
        final List<Integer> lotteryNumberList = getLotteryNumberList();

        if (isValidNumbers(numbersThatAlreadyExists)) {
            lotteryNumberList.removeAll(numbersThatAlreadyExists);
        }

        if (isEmpty(lotteryNumberList)) {
            throw new IllegalArgumentException(ERR_TEXT_THERE_IS_NOT_NUMBER);
        }

        Collections.shuffle(lotteryNumberList);

        return new LotteryNumber(lotteryNumberList.get(RANDOM_VALUE));
    }

    private static List<Integer> getLotteryNumberList() {
        final List<Integer> numbers = new ArrayList<>();
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    private static boolean isValidNumbers(final List<Integer> numbersThatAlreadyExists) {
        return (numbersThatAlreadyExists != null) && (numbersThatAlreadyExists.size() > EXIST);
    }

    private static boolean isEmpty(final List<Integer> numbersIntegers) {
        return numbersIntegers.size() == EMPTY;
    }

    public static LotteryNumber ofManual(final int givenNumber) {
        if ((START_NUMBER <= givenNumber) && (givenNumber <= END_NUMBER)) {
            return new LotteryNumber(givenNumber);
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
