package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(int lottoNumber) {
        validateRange(lottoNumber);
        return new LottoNumber(lottoNumber);
    }

    private static void validateRange(int lottoNumber) {
        if (!isInRange(lottoNumber)) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이여야 합니다.");
        }
    }

    private static boolean isInRange(int lottoNumber) {
        return lottoNumber >= 1 && lottoNumber <= 45;
    }

    public int getLottoNumber() {
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
