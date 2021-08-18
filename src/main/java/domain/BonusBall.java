package domain;

import java.util.Objects;

public class BonusBall {

    private int number;

    public BonusBall(int number) {
        if (number > LottoNumbers.MAX_LOTTO_NUM || number < LottoNumbers.MIN_LOTTO_NUM) {
            throw new IllegalArgumentException(LottoNumbers.MIN_LOTTO_NUM + " ~ " + LottoNumbers.MAX_LOTTO_NUM + "사이의 값만 들어올 수 있습니다.");
        }
        this.number = number;
    }

    public int getValue() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusBall bonusBall = (BonusBall) o;
        return number == bonusBall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
