package edu.nextstep.step2;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 23:28
 */
public class LotteryNumber {

    private static final int LIST_VALID_SIZE = 6;
    private List<Number> lotteryNumber;

    public LotteryNumber(List<Number> lotteryNumber) {
        validSize(lotteryNumber);
        this.lotteryNumber = lotteryNumber;
    }

    private void validSize(List<Number> lotteryNumber) {
        if(lotteryNumber.size() != LIST_VALID_SIZE) {
            throw new IllegalArgumentException("전달된 숫자가 6개가 아닙니다.");
        }
    }


}
