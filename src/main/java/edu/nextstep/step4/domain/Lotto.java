package edu.nextstep.step4.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class Lotto {

    private static final int LIST_VALID_SIZE = 6;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private List<Number> lotto;

    public Lotto(List<Number> lotto) {
        validSize(lotto);
        this.lotto = new ArrayList<>(lotto);
    }

    public static Lotto createLotteryNumber(String inputLotteryNumber) {
        return new Lotto(splitLotteryNumber(inputLotteryNumber));
    }

    public boolean contains(Number number) {
        return lotto.stream()
                .anyMatch(sourceNumber -> sourceNumber.equals(number));
    }

    public int compareMatchNumberCount(Lotto lotto) {
        return lotto.stream()
                .filter(compareSourceNumber -> this.contains(compareSourceNumber))
                .collect(Collectors.toList())
                .size();
    }

    public Stream<Number> stream() {
        return this.lotto.stream();
    }

    private void validSize(List<Number> lotteryNumber) {
        int numbers = lotteryNumber.stream()
                .map(Number::getNumber)
                .distinct()
                .collect(Collectors.toList())
                .size();
        if (numbers != LIST_VALID_SIZE) {
            throw new IllegalArgumentException("전달된 숫자가 6개가 아닙니다.");
        }
    }

    private static List<Number> splitLotteryNumber(String lottery) {
        return Arrays.stream(lottery.replaceAll(SPACE, "").split(COMMA))
                .filter(splitString -> !"".equals(splitString))
                .map(Integer::parseInt)
                .map(number -> Number.of(number))
                .collect(Collectors.toList());
    }

}
