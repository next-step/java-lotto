package edu.nextstep.step4.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 00:35
 */
public class RandomNumberUtils {

    private static final int VALUE_NUMBER_START_RANGE = 1;
    private static final int VALUE_NUMBER_END_RANGE = 45;
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 6;
    private static List<Integer> randomNumbers;

    static {
        randomNumbers = IntStream
                .rangeClosed(VALUE_NUMBER_START_RANGE, VALUE_NUMBER_END_RANGE)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> getExtractNumber() {
        shuffle();
        return new ArrayList<>(randomNumbers.subList(START_INDEX, END_INDEX));
    }

    private static void shuffle() {
        Collections.shuffle(randomNumbers);
    }
}
