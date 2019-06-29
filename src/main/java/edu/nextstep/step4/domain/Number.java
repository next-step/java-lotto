package edu.nextstep.step4.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 22:50
 */
public class Number {

    private static final int START_RANGE_NUMBER = 1;
    private static final int FINAL_RANGE_NUMBER = 45;
    private static final Map<Integer, Number> numbers = new HashMap<>();
    private int number;

    static {
        initNumber();
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        if (number < START_RANGE_NUMBER || number > FINAL_RANGE_NUMBER) {
            throw new IllegalArgumentException("숫자의 범위가 유효하지 않습니다.");
        }
        return numbers.get(number);
    }

    public int getNumber() {
        return this.number;
    }

    public boolean comapreTo(int sourceNumber) {
        return this.number == sourceNumber;
    }

    private static void initNumber() {
        for (int i = START_RANGE_NUMBER; i < FINAL_RANGE_NUMBER; i++) {
            numbers.put(i, new Number(i));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                '}';
    }
}
