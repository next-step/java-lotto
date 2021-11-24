package lotto.domain.value;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int LOTTO_MIN_NUMBER = 1;
    private final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {

        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("로또 숫자는 1~45의 숫자만 입력 가능합니다!!!!");
        }

        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return number + "";
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.number - lottoNumber.getNumber();
    }
}
