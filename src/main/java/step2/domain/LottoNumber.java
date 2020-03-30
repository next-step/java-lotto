package step2.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;
    public static final String LOTTO_NUMBER_RANGE_ERROR = "로또 번호는 1과 45 사이의 정수여야 합니다.";

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validatedNumberRange(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validatedNumberRange(int lottoNumber) {
        if(lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    public int getValue() {
        return lottoNumber;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(lottoNumber, o.getValue());
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
