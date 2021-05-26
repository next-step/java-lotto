package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.format;

public class LottoNumber {
    public static final Map<Integer, LottoNumber> ALL_LOTTO_NUMBERS = initializeAllLottoNumbers();
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String ILLEGAL_ARGUMENT_FORMAT = "로또 번호는 %d와(과) %d 사이의 숫자만 가능합니다.";
    private static final String ILLEGAL_ARGUMENT_MESSAGE
            = format(ILLEGAL_ARGUMENT_FORMAT, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);

    private int value;

    private LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber valueOf(int value) {
        validate(value);
        return ALL_LOTTO_NUMBERS.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public String toString() {
        return String.valueOf(value);
    }

    private static void validate(int value) {
        if (MIN_LOTTO_NUMBER > value || value > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }
    }

    private static Map<Integer, LottoNumber> initializeAllLottoNumbers() {
        Map<Integer, LottoNumber> result = new HashMap<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            result.put(i, new LottoNumber(i));
        }

        return result;
    }
}
