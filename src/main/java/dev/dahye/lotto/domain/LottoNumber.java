package dev.dahye.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {
    private static final List<Integer> numbers;
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    static {
        numbers = new ArrayList<>();

        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            numbers.add(i);
        }
    }

    public static List<Integer> getNumbers() {
        return numbers;
    }

    public static void validNumberRange(Integer number) {
        if (!numbers.contains(number)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
        }
    }
}
