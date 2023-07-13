package lottogame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumber {

    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private static final List<LottoNumber> CACHE;

    static {
        CACHE = new ArrayList<>();
        CACHE.add(new LottoNumber(0));
        for (int lottoNumber = MIN_LOTTO_NUMBER; lottoNumber <= MAX_LOTTO_NUMBER; lottoNumber++) {
            CACHE.add(new LottoNumber(lottoNumber));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    static LottoNumber valueOf(int lottoNumber) {
        assertLottoNumber(lottoNumber);
        return CACHE.get(lottoNumber);
    }

    private static void assertLottoNumber(final int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(
                String.format("로또 번호는 %d에서 %d 사이 값이어야 합니다 \"%d\"", MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, lottoNumber));
        }
    }

    int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber)) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
            "value=" + value +
            '}';
    }
}
