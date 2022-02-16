package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final String INVALID_NUMBER_RANGE = "복권의 숫자 범위가 유효하지 않습니다.";

    private static final Map<Integer, LottoNumber> numbers = new HashMap<>();

    static {
        IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
            .mapToObj(LottoNumber::new)
            .forEach(lottoNumber -> numbers.put(lottoNumber.value, lottoNumber));
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber from(int value) {
        validateNumberRange(value);
        return numbers.get(value);
    }

    private static void validateNumberRange(int value) {
        if (value < MINIMUM_NUMBER || value > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
