package lotto.domain;

import lotto.exception.LottoNumberException;

public class Number {

    private static final String ERR_NUMBER_FORMAT = "숫자 형식 데이터가 아닙니다";

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public Number(String number) {
        try {
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new LottoNumberException(ERR_NUMBER_FORMAT);
        }
    }

    public int getNumber() {
        return number;
    }
}
