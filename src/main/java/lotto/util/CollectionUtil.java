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
        for (int tryCount = NUMBER_COUNT_MINIMUM_BOUNDARY; tryCount < NUMBER_COUNT_MAXIMUM_BOUNDARY; tryCount++) {
            Number randomNumber = new Number(RandomUtil.getRandomNumber());
            if(randomNumbers.contains(randomNumber)) {
                tryCount--;
                continue;
            }
            randomNumbers.add(randomNumber);
        }
        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }

}
