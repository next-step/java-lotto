package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
    static final String LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION = "로또의 숫자는 1에서 45 사이의 숫자만 가능합니다.";
    static final int MIN_LOTTO_NUMBER = 1;
    static final int MAX_LOTTO_NUMBER = 45;
    private static final Map<Integer, LottoNumber> lottoNumberPool = new HashMap<>();

    static {
        for (int value = MIN_LOTTO_NUMBER; value <= MAX_LOTTO_NUMBER; value++) {
            lottoNumberPool.put(value, new LottoNumber(value));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        validateLottoNumber(value);
        this.value = value;
    }

    public static LottoNumber valueOf(int number) {
        return Optional.ofNullable(lottoNumberPool.get(number))
                .orElseThrow(() -> new IllegalStateException(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION));
    }

    public static List<LottoNumber> allNumbers() {
        return new ArrayList<>(lottoNumberPool.values());
    }

    private void validateLottoNumber(int number) {
        if (outOfRange(number)) {
            throw new IllegalStateException(LOTTO_NUMBER_OUT_OF_RANGE_EXCEPTION);
        }
    }

    private boolean outOfRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    public int getLottoNumber() {
        return value;
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
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "value=" + value +
                '}';
    }
}
