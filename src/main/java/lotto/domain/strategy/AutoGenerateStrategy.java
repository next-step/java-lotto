package lotto.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.LottoNumber;

public class AutoGenerateStrategy implements GenerateStrategy {
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final int NUMBERS_COUNT = 6;

    @Override
    public Set<LottoNumber> generate() {
        List<LottoNumber> numbers
            = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
            .boxed()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        Collections.shuffle(numbers);
        return Set.copyOf(numbers.subList(0, NUMBERS_COUNT));
    }
}
