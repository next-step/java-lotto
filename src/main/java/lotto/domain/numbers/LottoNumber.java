package lotto.domain.numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    private final int value;

    static {
        for (int number = LOTTO_START_NUMBER; number <= LOTTO_END_NUMBER; number++) {
            lottoNumbers.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber of(final int value) {
        LottoNumber lottoNumber = lottoNumbers.get(value);
        validate(lottoNumber);
        return lottoNumber;
    }

    public int getValue() {
        return value;
    }

    private void validate(final int value) {
        if (value < LOTTO_START_NUMBER || LOTTO_END_NUMBER < value) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d부터 %d까지여야 합니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
    }

    private static void validate(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException(
                    String.format("숫자는 %d부터 %d까지여야 합니다.", LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
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
}
