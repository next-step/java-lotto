package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int lottoNumber;

    LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.lottoNumber == lottoNumber.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }


    public int value() {
        return lottoNumber;
    }
}
