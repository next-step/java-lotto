package domain;

import java.util.Objects;

import static util.Constants.LOTTO_NUMBER_RANGE_HIGH;
import static util.Constants.LOTTO_NUMBER_RANGE_LOW;

public class LottoNo {
    private int number;

    private LottoNo(int number) {
        assert LOTTO_NUMBER_RANGE_LOW <= number && number <= LOTTO_NUMBER_RANGE_HIGH;

        this.number = number;
    }

    public static LottoNo of(int number) {
        return new LottoNo(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
