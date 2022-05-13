package study.step3.domain.strategy;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAuto implements LottoCreationStrategy {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 46;
    private static final List<Integer> DEFAULT_NUMBER_RANGE =
            IntStream.range(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE)
                    .boxed()
                    .collect(Collectors.toList());

    @Override
    public Set<Integer> createLottoNumber() {
        Collections.shuffle(DEFAULT_NUMBER_RANGE);
        Set<Integer> result = DEFAULT_NUMBER_RANGE.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toSet());
        return result;
    }
}
