package domain;

import util.RandomNumberGenerator;

public class LottoNumber {
    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 45;

    private Integer number;

    private static LottoNumber[] instances = new LottoNumber[MAX_NUMBER + 1];

    public static LottoNumber getInstance(){
        Integer number = RandomNumberGenerator.generateNumber(MIN_NUMBER, MAX_NUMBER);

        if(instances[number] == null){
            instances[number] = new LottoNumber(number);
        }

        return instances[number];
    }

    public static LottoNumber getInstance(Integer number){
        if(number < MIN_NUMBER || number > MAX_NUMBER){
            throw new IllegalArgumentException();
        }

        if(instances[number] == null){
            instances[number] = new LottoNumber(number);
        }

        return instances[number];
    }

    private LottoNumber(Integer number) {
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
