package edu.nextstep.step4.domain;

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
    private static final int MONEY_PER_NUMBER = 1000;
    private int extractCount;

    public Money(int extractCount) {
        validMoney(extractCount);
        this.extractCount = extractCount / MONEY_PER_NUMBER;
    }

    public int getNumberOfExtract() {
        return this.extractCount;
    }

    public int getInputMoney() {
        return this.extractCount * MONEY_PER_NUMBER;
    }

    private void validMoney(int extractCount) {
        if (extractCount < MONEY_PER_NUMBER) {
            throw new IllegalArgumentException("투입금액이 적습니다.");
        }
    }
}
