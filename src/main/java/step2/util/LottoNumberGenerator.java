package step2.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final int LOTTO_SIZE = 6;
    private static final List<Integer> POSSIBLE_LOTTO_NUMBERS = IntStream.range(1, 46)
        .boxed()
        .collect(Collectors.toList());

    public static List<Integer> generateLottoNumbers() {
        Collections.shuffle(POSSIBLE_LOTTO_NUMBERS);

        return POSSIBLE_LOTTO_NUMBERS.stream()
            .limit(LOTTO_SIZE)
            .sorted()
            .collect(Collectors.toList());
    }
}
