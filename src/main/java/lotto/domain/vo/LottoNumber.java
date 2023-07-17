package lotto.domain.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {

    public static final int LOTTO_START = 1;
    public static final int LOTTO_END = 45;
    private static final Map<Integer, LottoNumber> lottoNumberCache = new HashMap<>();

    private final Integer number;

    private LottoNumber(final Integer number) {
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        verify(number);
        lottoNumberCache.putIfAbsent(number, new LottoNumber(number));
        return lottoNumberCache.get(number);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
