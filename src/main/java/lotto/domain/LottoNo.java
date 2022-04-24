package lotto.domain;

import java.util.Objects;

public class LottoNo {

    private static final int MIN_VALID_NUMBER = 1;
    private static final int MAX_VALID_NUMBER = 45;

    private int number;
    public LottoNo(int number) {
        if (number < MIN_VALID_NUMBER || MAX_VALID_NUMBER < number) {
            throw new IllegalArgumentException("invalid lotto number: " + number);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
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
