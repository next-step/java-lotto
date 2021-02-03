package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private int number;

    public LottoNumber(int number){
        this.number = number;
        validate();
    }

    private void validate(){
        if(number < LottoNumber.MIN_LOTTO_NUMBER || number > LottoNumber.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("잘못된 로또 번호 입니다.");
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

    @Override
    public int compareTo(LottoNumber o) {
        if(this.number > o.number){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
