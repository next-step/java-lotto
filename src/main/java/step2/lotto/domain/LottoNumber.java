package step2.lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int LOTTO_MINIMUM_BOUND = 1;
    private static final int LOTTO_MAXIMUM_BOUND = 45;
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    private final int lottoNumber;

    static {
        IntStream.rangeClosed(LOTTO_MINIMUM_BOUND, LOTTO_MAXIMUM_BOUND)
            .forEach(i -> LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i)));
    }

    private LottoNumber(final int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(final int lottoNumber) {
        if (lottoNumber > LOTTO_MAXIMUM_BOUND || lottoNumber < LOTTO_MINIMUM_BOUND) {
            throw new IllegalArgumentException("로또 번호는 1이상 45이하의 숫자들로만 이루어져야 합니다.");
        }
        return LOTTO_NUMBER_CACHE.get(lottoNumber);
    }

    public int getNumber() {
        return lottoNumber;
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
