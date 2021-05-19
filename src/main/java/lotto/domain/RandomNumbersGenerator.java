package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.ValidationUtils.*;

public class RandomNumbersGenerator implements LottoNumbersGenerator {

    private static final List<Integer> LOTTO_NUMBERS_CANDIDATES = IntStream.range(MINIMUM_NUMBER, MAXIMUM_NUMBER).boxed().collect(Collectors.toList());

    @Override
    public List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS_CANDIDATES);
        return LOTTO_NUMBERS_CANDIDATES.stream().limit(LOTTO_NUMBERS_LENGTH).collect(Collectors.toList());
    }
}
