package edu.nextstep.step2;

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
    private static final int EXTRACT_COUNT = 6;
    private static List<Integer> randomNumber;

    public static void initNumber() {
        randomNumber = new ArrayList<>(IntStream
                .rangeClosed(VALUE_NUMBER_START_RANGE, VALUE_NUMBER_END_RANGE)
                .boxed()
                .collect(Collectors.toList()));
    }

    public static Lotto getLotto(Money money) {
        initNumber();

        List<ExtractionNumber> exNumber = new ArrayList<>();
        int extractCount = money.getNumberOfExtract();
        for (int i = 0; i < extractCount; i++) {
            exNumber.add(getExtractNumber());
        }
        return new Lotto(exNumber);
    }

    private static ExtractionNumber getExtractNumber() {
        shuffle();
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < EXTRACT_COUNT; i++) {
            numbers.add(new Number(randomNumber.get(i)));
        }
        return new ExtractionNumber(numbers);
    }

    private static void shuffle() {
        Collections.shuffle(randomNumber);
    }
}
