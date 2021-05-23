package step3.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator {

    private static final int START = 1;
    private static final int END = 45;
    private static final int LENGTH = 6;

    private static final List<Integer> LOTTO_RANGE = IntStream
        .rangeClosed(START, END).boxed()
        .collect(Collectors.toList());

    public static List<Integer> createNumbers() {
        Collections.shuffle(LOTTO_RANGE);
        return new ArrayList<Integer>(LOTTO_RANGE.subList(0, LENGTH));
    }

}
