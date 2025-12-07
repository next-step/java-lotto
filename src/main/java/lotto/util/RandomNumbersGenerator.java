package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumbersGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
    }

    public static List<Integer> randomNumbers() {
        Collections.shuffle(numbers);
        List<Integer> subList = numbers.subList(0, LOTTO_NUMBER_COUNT);
        Collections.sort(subList);

        return subList;
    }
}
