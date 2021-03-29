package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 45;
    private static final Random random = new Random();
    private final int lottoNumber;

    public LottoNumber() {
        this(autoNumber());
    }

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static int autoNumber() {
        return random.nextInt(BOUND_MAX) + BOUND_MIN;
    }

    public int lottoNumber() {
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
}
