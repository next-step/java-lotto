package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 46;
    private static final String LOTTO_NUMBER_SIZE_ERROR = "당첨 번호는 1 부터 45 이내 입력해주세요.";

    private static Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER)
                .forEach(i -> lottoNumberCache.put(i, new LottoNumber(i)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        isLottoNumberRange(number);
        return lottoNumberCache.get(number);
    }

    private static void isLottoNumberRange(int number) {
        if (isLottoNumberSize(number)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_SIZE_ERROR);
        }
    }

    private static boolean isLottoNumberSize(int number) {
        return (MIN_NUMBER > number)
                || (MAX_NUMBER <= number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
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
