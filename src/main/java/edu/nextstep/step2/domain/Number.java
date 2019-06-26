package edu.nextstep.step2.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 22:50
 */
public class Number {

    private static final int START_RANGE_NUMBER = 1;
    private static final int FINAL_RANGE_NUMBER = 45;
    private int number;

    public Number(int number) {
        validNumber(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean comapreTo(int sourceNumber) {
        return this.number == sourceNumber;
    }

    private void validNumber(int number) {
        if (number < START_RANGE_NUMBER) {
            throw new IllegalArgumentException("0보다 큰 수가 와야합니다.");
        }

        if (number > FINAL_RANGE_NUMBER) {
            throw new IllegalArgumentException("45이하의 수가 와야합니다.");
        }
    }
}
