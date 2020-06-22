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

    public LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        return numbers.get(number);
    }

    public int getNumber() {
        return number;
    }

    public static Map<Integer, LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
