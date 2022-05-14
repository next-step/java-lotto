package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {

    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_NUM_MIN = 1;
    private static final int LOTTO_NUM_MAX = 45;
    private static final List<LottoNumber> LOTTO_NUMBERS = IntStream.range(LOTTO_NUM_MIN, LOTTO_NUM_MAX)
            .mapToObj(LottoNumber::valueOf)
            .collect(Collectors.toList());

    public RandomLottoGenerator() {
    }

    @Override
    public Set<LottoNumber> get() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new HashSet<>(LOTTO_NUMBERS.subList(0, LOTTO_SIZE));
    }
}
