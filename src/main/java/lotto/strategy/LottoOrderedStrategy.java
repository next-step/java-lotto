package lotto.strategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoOrderedStrategy implements LottoNumberStrategy {
    static public final int LOTTO_COUNT_RANGE_MIN = 0;
    static public final int LOTTO_COUNT_RANGE_MAX = 6;
    static public final int LOTTO_NUMBER_MIN = 1;
    static public final int LOTTO_NUMBER_MAX = 45;

    @Override
    public List<Integer> generate() {
        return getOrderedNumbers().subList(LOTTO_COUNT_RANGE_MIN, LOTTO_COUNT_RANGE_MAX);
    }

    private List<Integer> getOrderedNumbers() {
        return IntStream.range(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
    }
}
