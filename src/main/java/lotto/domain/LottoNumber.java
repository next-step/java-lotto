package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private static final Integer MINIMUM_NUMBER = 1;
    private static final Integer MAXIMUM_NUMBER = 45;

    private final Integer lottoNumber;

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(Integer number) {
        validNumber(number);
        return new LottoNumber(number);
    }

    private static void validNumber(Integer number) {
        if (number == null) {
            throw new NullPointerException("숫자는 빈 값일 수 없습니다.");
        }
        if (number < MINIMUM_NUMBER || number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("%d ~ %d 값만 입력할 수 있습니다.", MINIMUM_NUMBER, MAXIMUM_NUMBER));
        }
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
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
