package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final String BOUNDARY_ERROR_MESSAGE =
            String.format("로또 번호의 범위는 %d ~ %d입니다.", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);

    private static final Map<Integer, LottoNumber> lottoNumbersCache = new HashMap<>();

    static {
        IntStream.rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .forEach(i -> lottoNumbersCache.put(i, new LottoNumber(i)));
    }

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        validateBoundary(number);
        return lottoNumbersCache.get(number);
    }

    private static void validateBoundary(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(BOUNDARY_ERROR_MESSAGE);
        }
    }

    public int lottoNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(number, o.number);
    }
}
