package lotto.domain;

import lotto.utils.ConvertUtil;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private static final int BOUND_MIN = 1;
    private static final int BOUND_MAX = 45;
    private static final String CHECK_BOUND = String.format("로또 번호는 %d ~ %d 범위의 값이어야 합니다.", BOUND_MIN, BOUND_MAX);
    private static final Random random = new Random();
    private final int lottoNumber;

    public LottoNumber() {
        this(autoNumber());
    }

    public LottoNumber(String lottoNumber) {
        this(ConvertUtil.toInt(lottoNumber));
    }

    public LottoNumber(int lottoNumber) {
        checkBound(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static int autoNumber() {
        return random.nextInt(BOUND_MAX) + BOUND_MIN;
    }

    public int lottoNumber() {
        return lottoNumber;
    }

    private void checkBound(Integer number) {
        if (BOUND_MIN > number || number > BOUND_MAX) {
            throw new IllegalArgumentException(CHECK_BOUND);
        }
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
