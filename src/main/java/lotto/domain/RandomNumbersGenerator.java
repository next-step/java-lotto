package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomNumbersGenerator implements LottoNumbersGenerator {

    private static final List<Integer> LOTTO_NUMBERS_CANDIDATES = IntStream.range(1, 45).boxed().collect(Collectors.toList());

    @Override
    public List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS_CANDIDATES);
        return LOTTO_NUMBERS_CANDIDATES.stream().limit(6).collect(Collectors.toList());
    }
}
