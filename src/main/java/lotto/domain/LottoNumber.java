package lotto.domain;

import java.util.*;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> numbers;
    private final int number;

    static {
        numbers = new HashMap<>();
        for (int idx = LOTTO_MIN_NUMBER; idx <= LOTTO_MAX_NUMBER; idx++) {
            numbers.put(idx, new LottoNumber(idx));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public LottoNumber valueOf(int number) {
        return numbers.get(number);
    }
}
