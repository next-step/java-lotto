package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    static final int LOTTO_START = 1;
    static final int LOTTO_END = 45;
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    private final Integer number;

    private LottoNumber(final Integer number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        verify(number);
        return lottoNumberCache.putIfAbsent(number, new LottoNumber(number));
    }

    private static void verify(final Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException(
                "lotto number should in range " + LOTTO_START + "~" + LOTTO_END);
        }
    }

    public Integer getNumber() {
        return number;
    }
}
