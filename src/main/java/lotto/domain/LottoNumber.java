package lotto.domain;

import java.util.Objects;

public class LottoNumber {

    private int number;


    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("숫자는 1~45 사이여야 합니다.");
        }
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
}
