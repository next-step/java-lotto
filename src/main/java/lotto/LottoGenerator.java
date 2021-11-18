package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
    private static final int TOTAL_LOTTO_NUMBER_COUNT = 45;
    private static final int DEFAULT_SELECT_COUNT = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = Stream.iterate(1, i -> i + 1)
                .limit(TOTAL_LOTTO_NUMBER_COUNT)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> autoMode() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .limit(DEFAULT_SELECT_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
