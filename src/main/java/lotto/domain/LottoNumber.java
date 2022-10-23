package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final String INVALID_LOTTO_NUMBER_BOUND_MESSAGE = "로또 번호는 1 ~ 45 의 숫자만 가능합니다.";
    static final List<LottoNumber> CACHE = new ArrayList<>();

    static {
        IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .forEach(number -> CACHE.add(new LottoNumber(number)));
    }

    private final int number;

    public LottoNumber(String number) {
        this(validateNumber(toInt(number)));
    }

    public LottoNumber(int number) {
        this.number = validateNumber(number);
    }

    public static LottoNumber of(int number) {
        try {
            return CACHE.get(number - 1);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }
    }

    private static int toInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }
    }

    private static int validateNumber(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_BOUND_MESSAGE);
        }
        return number;
    }

    int getNumber() {
        return number;
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
