package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(String number) {
        this(Integer.parseInt(number));
    }

    public LottoNumber(int number) {
        validationLottoNumber(number);
        this.number = number;
    }

    private void validationLottoNumber(int number) {
        if(number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("정확하지 않은 로또 번호입니다.");
        }
    }

    public int getLottoNumber() {
        return number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        if(this.number > lottoNumber.getLottoNumber()){
            return 1;
        }
        return -1;
    }
}
