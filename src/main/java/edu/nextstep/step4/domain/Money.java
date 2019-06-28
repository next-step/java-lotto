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
    private int manualCount;

    public Money(int extractCount, int manualCount) {
        validMoney(extractCount, manualCount);
        this.extractCount = extractCount / MONEY_PER_NUMBER;
        this.manualCount = manualCount;
    }

    public int getNumberOfExtract() {
        return this.extractCount;
    }

    public int getNumberOfManual() {
        return this.manualCount;
    }

    public int getInputMoney() {
        return this.extractCount * MONEY_PER_NUMBER;
    }

    private void validMoney(int extractCount, int manualCount) {
        if (extractCount < MONEY_PER_NUMBER) {
            throw new IllegalArgumentException("투입금액이 적습니다.");
        }

        int extract = (extractCount / MONEY_PER_NUMBER) - manualCount;
        if (extract < 0) {
            throw new IllegalArgumentException("투입 금액에 비해 수동생성 가능 개수가 많습니다.");
        }
    }
}
