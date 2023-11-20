package step2.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class LottoNumberRandomGenerator implements LottoNumberGenerator {

    private static final int LOTTO_MINIMUM_RANGE_BOUND = 1;
    private static final int LOTTO_MAXIMUM_RANGE_BOUND = 45;
    private static final int LOTTO_MINIMUM_GAME_BOUND = 0;
    private static final int LOTTO_MAXIMUM_GAME_BOUND = 6;

    @Override
    public Set<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(LOTTO_MINIMUM_RANGE_BOUND, LOTTO_MAXIMUM_RANGE_BOUND).forEach(i -> numbers.add(i));
        Collections.shuffle(numbers);
        return Set.copyOf(numbers.subList(LOTTO_MINIMUM_GAME_BOUND, LOTTO_MAXIMUM_GAME_BOUND));
    }
}
