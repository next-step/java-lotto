package step2.lotto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberRandomGenerator implements LottoNumberGenerator {

    private static final int LOTTO_MINIMUM_RANGE_BOUND = 1;
    private static final int LOTTO_MAXIMUM_RANGE_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private static final List<Integer> BASE_NUMBERS =
        IntStream.rangeClosed(
            LOTTO_MINIMUM_RANGE_BOUND, LOTTO_MAXIMUM_RANGE_BOUND)
        .boxed()
        .collect(Collectors.toList());

    @Override
    public Set<Integer> generateLottoNumbers() {
        List<Integer> shuffledNumbers = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(shuffledNumbers);
        return shuffledNumbers.stream()
                    .limit(LOTTO_NUMBER_COUNT)
                    .collect(Collectors.toSet());
    }
}
