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
    private static final int MONEY_PER_NUMBER = 1_000;
    private final int money;

    public Money(int inputMoney) {
        validMoney(inputMoney);
        this.money = inputMoney;
    }

    public int getInputMoney() {
        return this.money;
    }

    public int getAutoNumber(int manualCount) {
        return this.money / MONEY_PER_NUMBER - manualCount;
    }

    private void validMoney(int inputMoney) {
        if (inputMoney < MONEY_PER_NUMBER) {
            throw new IllegalArgumentException("투입금액이 적습니다.");
        }
    }
}
