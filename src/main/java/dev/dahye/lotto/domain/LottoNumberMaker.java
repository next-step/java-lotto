package dev.dahye.lotto.domain;

import java.util.List;

import static java.util.Collections.shuffle;

public class LottoNumberMaker {
    public static final int ZERO_VALUE = 0;
    public static final int MAX_VALUE = 45;

    public static List<Integer> createShuffled(int maxSize) {
        validateMaxSize(maxSize);
        List<Integer> numbers = LottoNumbers.getNumbers();
        shuffle(numbers);

        return numbers.subList(ZERO_VALUE, maxSize);
    }

    private static void validateMaxSize(int maxSize) {
        if (maxSize > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호의 최대 사이즈는 45입니다.");
        }
    }
}
