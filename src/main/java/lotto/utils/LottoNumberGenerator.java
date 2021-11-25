package lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.model.Number;

public final class LottoNumberGenerator {

    private static final int FIRST_LOTTO_NUMBER = 1;
    private static final int LAST_LOTTO_NUMBER_BOUND = 46;
    private static final int COUNT_TO_PICK = 6;
    private static List<Integer> initNumbers;

    static {
        initNumbers = IntStream.range(FIRST_LOTTO_NUMBER, LAST_LOTTO_NUMBER_BOUND)
                               .boxed()
                               .collect(Collectors.toList());
    }

    private LottoNumberGenerator() {
    }

    public static List<Number> generate() {
        List<Integer> sortedInitNumbers = initNumbers.stream()
                                                     .sorted()
                                                     .collect(Collectors.toList());
        return pickNumbers(sortedInitNumbers);
    }

    private static List<Number> pickNumbers(List<Integer> allNumbers) {
        Collections.shuffle(allNumbers);
        return allNumbers.stream()
                         .limit(COUNT_TO_PICK)
                         .sorted()
                         .map(Number::new)
                         .collect(Collectors.toList());
    }
}
