package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static util.Preconditions.checkArgument;

public class LottoNumber {
    public static final String LOTTO_NUMBER_INVALID_RANGE = "lotto number must between 1 and 45";
    public static final int MIN_NO = 1;
    public static final int MAX_NO = 45;
    private static final Map<Integer, LottoNumber> lottoNos = new HashMap<>();

    static {
        for (int i = MIN_NO; i <= MAX_NO; i++) {
            lottoNos.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(final int number) {
        this.value = number;
    }

    public static LottoNumber of(final int number) {
        checkArgument(number >= MIN_NO && number <= MAX_NO, LOTTO_NUMBER_INVALID_RANGE);
        return lottoNos.get(number);
    }

    public int getValue() {
        return value;
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
