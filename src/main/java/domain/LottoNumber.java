package domain;

import exception.ExceedNumberException;
import exception.NegativeException;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateNegativeNumber(lottoNumber);
        validateExceedNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateExceedNumber(int lottoNumber) {
        if(lottoNumber > MAX_NUMBER) {
            throw new ExceedNumberException("45 숫자를 초과 할 수 없습니다.");
        }
    }

    private static void validateNegativeNumber(int lottoNumber) {
        if(lottoNumber < MIN_NUMBER) {
            throw new NegativeException("음수는 입력 할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return lottoNumber;
    }

    @Override
    public String toString(){
        return String.valueOf(lottoNumber);
    }
}
