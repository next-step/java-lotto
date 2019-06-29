package edu.nextstep.step4.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
    private Set<Number> lotto;

    public Lotto(Set<Number> lotto) {
        validSize(lotto);
        this.lotto = new HashSet<>(lotto);
    }

    public static Lotto createLotteryNumber(String inputLotteryNumber) {
        return new Lotto(splitLotteryNumber(inputLotteryNumber));
    }

    public boolean contains(Number number) {
        return lotto.stream()
                .anyMatch(sourceNumber -> sourceNumber.equals(number));
    }

    public Stream<Number> stream() {
        return this.lotto.stream();
    }

    private void validSize(Set<Number> lotteryNumber) {
        int numbers = lotteryNumber.stream()
                .map(Number::getNumber)
                .collect(Collectors.toList())
                .size();
        if (numbers != LIST_VALID_SIZE) {
            throw new IllegalArgumentException("전달된 숫자가 6개가 아닙니다.");
        }
    }

    private static Set<Number> splitLotteryNumber(String lottery) {
        return new HashSet<>(Arrays.stream(lottery.replaceAll(SPACE, "").split(COMMA))
                .filter(splitString -> !"".equals(splitString))
                .map(Integer::parseInt)
                .map(number -> Number.of(number))
                .collect(Collectors.toSet()));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
