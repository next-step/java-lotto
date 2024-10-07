package step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class NumberExtractor {

    public static Queue<Integer> extract(String[] values) {
        return Arrays.stream(values).filter(v -> !StringCalculator.isOperator(v))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
