package domain;

import util.RandomNumberGenerator;

public class LottoNumber {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;

    private Integer number;

    public LottoNumber() {
        this.number = RandomNumberGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);
    }

    public LottoNumber(Integer number) {
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        if(obj == this){
            return true;
        }

        if(obj.getClass() == getClass()){
            LottoNumber lottoNumber = (LottoNumber)obj;

            return lottoNumber.number.equals(number);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
