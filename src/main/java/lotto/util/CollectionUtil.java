package lotto.util;

import lotto.domain.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionUtil {

    private static final int NUMBER_COUNT_MINIMUM_BOUNDARY = 0;
    private static final int NUMBER_COUNT_MAXIMUM_BOUNDARY = 6;
    public static List<Number> createRandomNumbers() {
        List<Number> randomNumbers = new ArrayList<>();
        for (int i = NUMBER_COUNT_MINIMUM_BOUNDARY; i < NUMBER_COUNT_MAXIMUM_BOUNDARY; i++) {
            Number randomNumber = new Number(RandomUtil.getRandomNumber());
            randomNumbers.add(randomNumber);
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }

}
