package lotto;

import java.util.Objects;

public class LottoNumber {
    private final int number;
    private final int LOTTO_START_NUMBER    = 1;
    private final int LOTTO_END_NUMBER      = 45;


    public LottoNumber(final int number) {
        if(number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("1부터 45 사이 숫자만 가능합니다.");
        }
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int getNumber() {
        return this.number;
    }
}
