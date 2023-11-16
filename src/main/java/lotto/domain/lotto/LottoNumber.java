package lotto.domain.lotto;

import java.util.Objects;

public class LottoNumber {

    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 45;
    private static final String NUMBER_ERROR_MESSAGE = String.format("로또 번호는 %s ~ %s 사이의 숫자이어야 합니다.", NUMBER_MIN, NUMBER_MAX);

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        validateRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(Integer lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private void validateRange(int number) {
        if (number < NUMBER_MIN || number > NUMBER_MAX) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

    public int value() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
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
