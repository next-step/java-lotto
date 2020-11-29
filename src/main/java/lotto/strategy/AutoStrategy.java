package lotto.strategy;

import lotto.model.lotto.LottoNumber;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoStrategy implements DrawingStrategy {
    private final static List<Integer> candidates = IntStream.rangeClosed(1, THRESHOLD)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public SortedSet<LottoNumber> drawNumbers() {
        Collections.shuffle(candidates);

        return candidates.subList(0, NUMBER_COUNT)
                .stream()
                .map(LottoNumber::of)
                .collect(Collectors.toCollection(TreeSet::new));
    }

}
