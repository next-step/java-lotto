package edu.nextstep.step4.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-28 15:09
 */
public class WinLotto {

    private Lotto lottery;
    private Number bonusNumber;

    private WinLotto(Lotto lottery, Number bonusNumber) {
        this.lottery = lottery;
        this.bonusNumber = bonusNumber;
    }

    public static WinLotto of(Lotto lottery, Number bonusNumber) {
        return new WinLotto(lottery, bonusNumber);
    }
}
