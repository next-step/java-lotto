package edu.nextstep.step4.domain;

import java.util.stream.Collectors;

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

    public int compareMatchNumberCount(Lotto lotto) {
        return lotto.stream()
                .filter(compareSourceNumber -> lottery.contains(compareSourceNumber))
                .collect(Collectors.toList())
                .size();
    }

    // Number객체의 데이터변조 가능한 메서드가 없어 getter 사용
    public Number getBonusNumber() {
        return this.bonusNumber;
    }
}
