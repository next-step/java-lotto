package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.compare;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final String NOT_VALID_RANGE = "번호의 범위에 해당하지 않습니다.";
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_MAP = new HashMap<>();

    static {
        initLottoNumberCaches();
    }

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private static void initLottoNumberCaches() {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            LOTTO_NUMBER_MAP.put(number, new LottoNumber(number));
        }
    }

    private void validate(int number) {
        if (MIN_NUMBER > number || MAX_NUMBER < number) {
            throw new IllegalArgumentException(NOT_VALID_RANGE);
        }
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return compare(this.number, lottoNumber.number);
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
