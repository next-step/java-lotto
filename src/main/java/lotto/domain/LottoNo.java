package lotto.domain;

import java.util.Objects;

public class LottoNo {

    public static final int LOTTO_NUMBER_BOUND = 45;
    private int number;

    private LottoNo(int number) {
        if (isValidNumber(number)) {
            throw new IllegalArgumentException();
        }
        this.number = number;
    }

    public static LottoNo create(int number) {
        return new LottoNo(number);
    }

    public static LottoNo create(String number) {
        return new LottoNo(Integer.parseInt(number));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof LottoNo)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        LottoNo target = (LottoNo) obj;
        return number == target.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    private boolean isValidNumber(int number) {
        return number < 0 || LOTTO_NUMBER_BOUND < number;
    }
}
