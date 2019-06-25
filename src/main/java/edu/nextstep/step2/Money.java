package edu.nextstep.step2;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 00:27
 */
public class Money {
    private static final int DIVID_NUMBER = 1000;
    private int extractCount;

    public Money(int extractCount) {
        validMoney(extractCount);
        this.extractCount = extractCount / DIVID_NUMBER;
    }

    public int getNumberOfExtract() {
        return this.extractCount;
    }

    public int getInputMoney() {
        return this.extractCount * DIVID_NUMBER;
    }

    private void validMoney(int extractCount) {
        if (extractCount < DIVID_NUMBER) {
            throw new IllegalArgumentException("투입금액이 적습니다.");
        }
    }
}
