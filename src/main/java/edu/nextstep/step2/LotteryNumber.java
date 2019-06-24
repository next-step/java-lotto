package edu.nextstep.step2;

import java.util.List;
import java.util.stream.Collectors;

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

    public boolean contains(int number) {
        return lotteryNumber.stream()
                .filter(sourceNumber -> sourceNumber.comapreTo(number))
                .findFirst()
                .isPresent();
    }

    public int compareMatchNumberCount(ExtractionNumber exNumber) {
        return exNumber.stream()
                .filter(compareSourceNumber -> this.contains(compareSourceNumber.getNumber()))
                .collect(Collectors.toList())
                .size();
    }

    private void validSize(List<Number> lotteryNumber) {
        if(lotteryNumber.size() != LIST_VALID_SIZE) {
            throw new IllegalArgumentException("전달된 숫자가 6개가 아닙니다.");
        }
    }

}
