package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int BOTTOM_OF_RANGE = 1;
    public static final int TOP_OF_RANGE = 45;
    public static final String OUT_OF_BOUNDS_MESSAGE =
            "로또 숫자의 범위는 " + BOTTOM_OF_RANGE + " ~ " + 45 + " 입니다.";

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        if (lottoNumber < BOTTOM_OF_RANGE || lottoNumber > TOP_OF_RANGE) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_MESSAGE);
        }
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(int number) {
        return new LottoNumber(number);
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
