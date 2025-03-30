package lotto.domain;


import java.util.Objects;

import static lotto.common.Constants.LOTTO_NUMBER_LOWER_BOUND;
import static lotto.common.Constants.LOTTO_NUMBER_UPPER_BOUND;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;
    
    public LottoNumber(int number){
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < LOTTO_NUMBER_LOWER_BOUND || number > LOTTO_NUMBER_UPPER_BOUND) {
            throw new IllegalArgumentException("로또 번호의 범위는 " + LOTTO_NUMBER_LOWER_BOUND + "부터 " + LOTTO_NUMBER_UPPER_BOUND + "까지 입니다.");
        }
    }

    @Override
    public int compareTo(LottoNumber comparatorNumber) {
        return this.number - comparatorNumber.number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    public int getValue() {
        return this.number;
    }
}
