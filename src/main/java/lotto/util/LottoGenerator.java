package lotto.util;

import lotto.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    public static final int DEFAULT_SIZE = 6;

    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static Set<LottoNumber> auto() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.stream()
                .limit(DEFAULT_SIZE)
                .collect(Collectors.toSet());
    }
}
