package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {
    private static final List<Integer> LOTTO_CANDIDATE_NUMBERS = IntStream.rangeClosed(LOTTO_NUMBER_LOWER_LIMIT, LOTTO_NUMBER_UPPER_LIMIT)
            .boxed()
            .collect(Collectors.toList());

    @Override
    public Set<Integer> generateNumbers() {
        Collections.shuffle(LOTTO_CANDIDATE_NUMBERS);

        return LOTTO_CANDIDATE_NUMBERS.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toSet());
    }
}
