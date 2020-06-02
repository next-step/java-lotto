package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class LottoNumbers {
    public static final int ZERO_VALUE = 0;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private static final List<Integer> numbers;

    static {
        numbers = new ArrayList<>();

        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            numbers.add(i);
        }
    }

    public static List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public static List<Integer> createShuffled(int maxSize) {
        validateMaxSize(maxSize);
        List<Integer> numbers = getNumbers();
        shuffle(numbers);

        return numbers.subList(ZERO_VALUE, maxSize);
    }

    private static void validateMaxSize(int maxSize) {
        if (maxSize > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호의 최대 사이즈는 45입니다.");
        }
    }

    public static void validNumberRange(Integer number) {
        if (!numbers.contains(number)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
        }
    }
}
