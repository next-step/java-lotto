package domain;

import exception.ExceedNumberException;

public class LottoNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateExceedNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateExceedNumber(int lottoNumber) {
        if(lottoNumber > MAX_NUMBER || lottoNumber < MIN_NUMBER) {
            throw new ExceedNumberException("1에서 45 숫자만 입력할 수 있습니다.");
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
