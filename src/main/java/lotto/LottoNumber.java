package lotto;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER = 45;
    private static final String RANGE_NUMBER_MESSAGE = " 범위가 벗어난 값이 존재합니다.";
    private static final String TILDE = " ~ ";
    private static final String WRONG_NUMBER_RANGE_MESSAGE =
            FIRST_LOTTO_NUMBER + TILDE + LAST_LOTTO_NUMBER + RANGE_NUMBER_MESSAGE;

    private static final Map<Integer, LottoNumber> cache = new HashMap<>();

    private final int lottoNumber;

    static {
        IntStream.rangeClosed(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER)
                .forEach(i -> cache.put(i, new LottoNumber(i)));
    }

    private LottoNumber(int lottoNumber) {
        validate(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validate(int lottoNumber) {
        if (lottoNumber < FIRST_LOTTO_NUMBER || lottoNumber > LAST_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WRONG_NUMBER_RANGE_MESSAGE);
        }
    }

    public static LottoNumber valueOf(String lottoNumber) {
        return valueOf(Integer.parseInt(lottoNumber));
    }

    public static LottoNumber valueOf(int lottoNumber) {
        LottoNumber cachedLottoNumber = cache.get(lottoNumber);
        if (cachedLottoNumber == null) {
            throw new IllegalArgumentException(WRONG_NUMBER_RANGE_MESSAGE);
        }
        return cachedLottoNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return Integer.toString(lottoNumber);
    }
}
