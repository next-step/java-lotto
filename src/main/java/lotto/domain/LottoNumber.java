package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.compare;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    private static final String NOT_VALID_RANGE = "번호의 범위에 해당하지 않습니다.";
    private static final String ILLEGAL_NUMBER_FORMAT = "입력 형식이 올바르지 않습니다.";
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        initLottoNumberCaches();
    }

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public static LottoNumber of(int number) {
        return LOTTO_NUMBER_CACHE.get(number);
    }

    public static LottoNumber of(String input) {
        return of(parseToInt(input));
    }

    private static void initLottoNumberCaches() {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            LOTTO_NUMBER_CACHE.put(number, new LottoNumber(number));
        }
    }

    private static int parseToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ILLEGAL_NUMBER_FORMAT);
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

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
