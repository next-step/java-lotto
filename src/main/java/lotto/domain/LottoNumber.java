package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private final static int MAX_VALUE = 45;
    private final static int MIN_VALUE = 1;
    private final static String LOTTO_NUMBER_EXCEPTION =  "로또 번호는 1 미만, 45 초과 여야니다.";
    private int number;

    public LottoNumber(int number){
        validation(number);
        this.number = number;
    }

    protected void validation( int number) {
        boolean isMax = number > MAX_VALUE ;
        boolean isMin = number < MIN_VALUE ;
        if( (isMin) || (isMax) ){
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION);
        }
    }

    public int atomicNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }
}
