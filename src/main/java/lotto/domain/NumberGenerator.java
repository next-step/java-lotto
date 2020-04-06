package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NumberGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Integer> numberRange = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(Integer::new)
            .collect(toList());

    static List<Integer> generateLotto(int numberCount) {
        Collections.shuffle(numberRange, new Random(System.currentTimeMillis()));

        List<Integer> oneSet = new ArrayList<>();
        for (int i = 0; i < numberCount; i++) {
            oneSet.add(numberRange.get(i));
        }
        Collections.sort(oneSet);

        return oneSet;
    }
}
