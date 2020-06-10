package study.step4.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {
    private static final int INIT_NUMBER = 1;
    private static final int LIMITED_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    private static List<LottoNumber> numbers = IntStream.rangeClosed(INIT_NUMBER, LIMITED_NUMBER)
                                                        .mapToObj(LottoNumber::cacheNumber)
                                                        .collect(toList());

    private LottoNumbers(){}

    public static Set<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                      .limit(LOTTO_NUMBERS_COUNT)
                      .collect(Collectors.toSet());
    }
}