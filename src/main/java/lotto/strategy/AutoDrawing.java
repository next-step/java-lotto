package lotto.strategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoDrawing extends DrawingStrategy {
    private final static List<Integer> candidates = IntStream.rangeClosed(1, THRESHOLD)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<Integer> drawNumbers() {
        Collections.shuffle(candidates);

        return new HashSet<>(candidates.subList(0, NUMBER_COUNT));
    }

}
