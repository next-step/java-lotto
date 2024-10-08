package step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OperatorExtractor {

    private static final OperatorExtractor instance = new OperatorExtractor();

    private OperatorExtractor() {
    }

    public static OperatorExtractor getInstance() {
        return instance;
    }

    public static Queue<String> extract(String[] values) {
        return IntStream.range(0, values.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> values[i])
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
