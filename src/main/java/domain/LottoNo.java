package domain;

import java.util.Objects;

public class LottoNo {
    private int number;
    private static final int LAST_NUMBER = 45;
    private static final int ONE = 1;

    public LottoNo(int number) {
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

    public boolean validateNumber() {
        if (number >= ONE && number <= LAST_NUMBER) {
            return true;
        }
        return false;
    }
}
