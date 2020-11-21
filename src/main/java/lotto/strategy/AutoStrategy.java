package lotto.strategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoStrategy extends DrawingStrategy {
    private final static List<Integer> candidates = IntStream.rangeClosed(1, THRESHOLD)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public SortedSet<Integer> drawNumbers() {
        Collections.shuffle(candidates);

        return new TreeSet<>(candidates.subList(0, NUMBER_COUNT));
    }

}
