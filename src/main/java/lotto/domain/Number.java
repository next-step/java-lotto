package lotto.domain;

import lotto.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class Number {
    private static final Map<Integer, Number> numbers = new HashMap<>();

    private final int number;

    static {
        for (int i = Constants.LOTTO_MIN_BOUND; i <= Constants.LOTTO_MAX_BOUND; i++) {
            numbers.put(i, new Number(i));
        }
    }

    private Number(final int number) {
        this.number = number;
    }

    public static Number from(final int num) {
        Number number = numbers.get(num);
        if (number == null) {
            throw new RuntimeException("로또에서 가능한 범위를 초과한 숫자입니다.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }
}
