package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomIntegersGenerator {

    private static final int RANGE_START_INCLUSIVE = 1;
    private static final int RANGE_END_EXCLUSIVE = 46;
    private static final int DEFAULT_NUMBERS_LENGTH = 6;

    private static final List<Integer> numbersOfRange = IntStream.range(RANGE_START_INCLUSIVE, RANGE_END_EXCLUSIVE)
            .mapToObj(i -> i)
            .collect(Collectors.toList());

    private RandomIntegersGenerator() {
    }

    static List<Integer> createNumberList() {
        return createNumberList(DEFAULT_NUMBERS_LENGTH);
    }

    static List<Integer> createNumberList(int length) {
        Collections.shuffle(numbersOfRange);
        List<Integer> newNumberList = new ArrayList<>(numbersOfRange.subList(0, length));
        return sortList(newNumberList);
    }

    private static List<Integer> sortList(List<Integer> newNumberList) {
        Collections.sort(newNumberList);
        return newNumberList;
    }

}
