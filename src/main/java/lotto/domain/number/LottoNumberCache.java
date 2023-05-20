package lotto.domain.number;

import lotto.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoNumberCache {

    private static final int MIN_LOTTO_NUMBER = 1;

    private static final int MAX_LOTTO_NUMBER = 45;

    public static final List<LottoNumber> LOTTO_NUMBER_CACHE = new ArrayList<>();

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(number -> LOTTO_NUMBER_CACHE.add(new LottoNumber(number)));
    }

    public static LottoNumber valueOf(String number) {
        return LOTTO_NUMBER_CACHE.get(Util.convertInt(number) - 1);
    }
}
