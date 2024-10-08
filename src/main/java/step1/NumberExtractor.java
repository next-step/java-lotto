package step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberExtractor {

    private static final NumberExtractor instance = new NumberExtractor();

    private NumberExtractor() {
    }

    public static NumberExtractor getInstance() {
        return instance;
    }

    public static Queue<Integer> extract(String[] values) {
        return IntStream.range(0, values.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> values[i])
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
