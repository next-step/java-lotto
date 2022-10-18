package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final int RANGE_BEGIN_NUMBER = 1;
    private static final int RANGE_END_NUMBER = 45;
    private static final int NUMBER_SIZE = 6;

    public static List<Integer> generate() {
        List<Integer> lottoRangeNumbers = IntStream.range(RANGE_BEGIN_NUMBER, RANGE_END_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoRangeNumbers);
        lottoRangeNumbers = lottoRangeNumbers.stream()
                .limit(NUMBER_SIZE)
                .sorted()
                .collect(Collectors.toList());
        return lottoRangeNumbers;
    }
}
