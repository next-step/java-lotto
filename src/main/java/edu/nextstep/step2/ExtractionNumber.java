package edu.nextstep.step2;

import java.util.List;
import java.util.stream.Stream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-24 23:00
 */
public class ExtractionNumber {

    private static final int LIST_VALID_SIZE = 6;
    private List<Number> exNumber;

    public ExtractionNumber(List<Number> exNumber) {
            validSize(exNumber);
            this.exNumber = exNumber;
    }

    public Stream<Number> stream() {
        return exNumber.stream();
    }

    private void validSize(List<Number> exNumber) {
        if(exNumber.size() != LIST_VALID_SIZE) {
            throw new IllegalArgumentException("전달된 숫자가 6개가 아닙니다.");
        }
    }
}
