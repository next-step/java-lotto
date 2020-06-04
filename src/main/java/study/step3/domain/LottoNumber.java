package study.step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {
    private final static int INIT_NUMBER = 1;
    private final static int LIMITED_NUMBER = 45;
    public final static int LOTTO_NUMBERS_COUNT = 6;

    private static List<Integer> numbers = IntStream.rangeClosed(INIT_NUMBER, LIMITED_NUMBER)
                                             .boxed()
                                             .collect(Collectors.toList());

    private LottoNumber(){}

    public static Set<Integer> getLottoNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                      .limit(LOTTO_NUMBERS_COUNT)
                      .collect(Collectors.toSet());
    }
}
