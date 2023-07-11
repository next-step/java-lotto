package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    static final int LOTTO_START = 1;
    static final int LOTTO_END = 45;
    private static final List<LottoNumber> lottoNumberCache = IntStream.rangeClosed(0, LottoNumber.LOTTO_END)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    private final Integer number;

    private LottoNumber(final Integer number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        verify(number);
        return lottoNumberCache.get(number);
    }

    private static void verify(final Integer number) {
        if (number < LOTTO_START || number > LOTTO_END) {
            throw new IllegalArgumentException("lotto number should in range " + LOTTO_START + "~" + LOTTO_END);
        }
    }

    public Integer getNumber() {
        return number;
    }
}
