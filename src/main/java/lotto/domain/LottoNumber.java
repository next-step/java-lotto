package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    public static final Map<Integer, LottoNumber> LOTTO_NUMBERS = new HashMap<>(MAX_NUMBER);

    private int number;

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber from(int number) {
        valid(number);
        return LOTTO_NUMBERS.get(number);
    }

    private static void valid(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자는 1 ~ 45 만 가능합니다.");
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
