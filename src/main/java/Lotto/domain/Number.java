package Lotto.domain;

import Lotto.exception.OverflowNumberException;

public class Number {

    private static final int LOTTO_MAX_NUMBER = 45;

    private int number;

    public Number(int lottoNum) {
        validate(lottoNum);
        
        this.number = lottoNum;
    }

    private void validate(int lottoNum) {
        if (lottoNum > LOTTO_MAX_NUMBER) {
            throw new OverflowNumberException("로또 숫자는 " + LOTTO_MAX_NUMBER + "이하의 수입니다.");
        }
    }

    public int getNumber() {
        return number;
    }

}
