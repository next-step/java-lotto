package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberGenerator {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_ONE_SET_SIZE = 6;

    private static final List<Integer> numberRange = Stream.iterate(MIN_LOTTO_NUMBER, n -> n + 1)
            .limit(MAX_LOTTO_NUMBER)
            .collect(Collectors.toList());

    static List<Integer> generateOneSet() {
        Collections.shuffle(numberRange, new Random(System.currentTimeMillis()));

        List<Integer> oneSet = new ArrayList<>();
        for (int i = 0; i < LOTTO_ONE_SET_SIZE; i++) {
            oneSet.add(numberRange.get(i).intValue());
        }
        Collections.sort(oneSet);

        return oneSet;
    }
}
