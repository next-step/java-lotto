package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberGeneration {
    private NumberGeneration() {
    }

    public static List<Integer> getLottoAllNumberInRange() {
        return IntStream.range(LottoNumber.LOTTO_NUMBER_RANGE_MIN, LottoNumber.LOTTO_NUMBER_RANGE_MAX)
                .boxed()
                .collect(Collectors.toList());
    }
}
