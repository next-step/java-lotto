package lotto.strategy;

import lotto.model.lotto.LottoNumber;
import lotto.model.lotto.LottoTicket;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoStrategy implements DrawingStrategy {
    private final static List<Integer> candidates = IntStream.rangeClosed(1, THRESHOLD)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public LottoTicket drawNumbers() {
        Collections.shuffle(candidates);

        SortedSet<LottoNumber> numbers = candidates.subList(0, NUMBER_COUNT)
                .stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));

        return new LottoTicket(numbers);
    }

}
