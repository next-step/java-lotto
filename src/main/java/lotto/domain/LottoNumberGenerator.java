package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumberGenerator {
    private LottoNumberGenerator() {
    }

    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static Set<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<Integer> tempNumber = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            tempNumber.add(LOTTO_NUMBERS.get(i));
        }

        Collections.sort(tempNumber);

        return tempNumber.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

}
