package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class LottoNumberExtractor {
    public static final int ZERO_VALUE = 0;
    private static final List<Integer> numbers;

    static {
        numbers = new ArrayList<>();

        for (int i = LottoNumber.MIN_VALUE; i <= LottoNumber.MAX_VALUE; i++) {
            numbers.add(i);
        }
    }

    public static List<Integer> createShuffled(int maxSize) {
        validateMaxSize(maxSize);
        List<Integer> numbers = getNumbers();
        shuffle(numbers);

        return numbers.subList(ZERO_VALUE, maxSize);
    }

    private static List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private static void validateMaxSize(int maxSize) {
        if (maxSize > LottoNumber.MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호의 최대 사이즈는 " + LottoNumber.MAX_VALUE + "입니다.");
        }
    }
}
