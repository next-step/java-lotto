package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumbersCache = new HashMap<>();

    private final int number;

    private LottoNumber(final int number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        validate(number);
        return lottoNumbersCache.putIfAbsent(number, new LottoNumber(number));
    }

    private static void validate(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
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
