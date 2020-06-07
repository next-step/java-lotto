package study.step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumbers {
    private final static int INIT_NUMBER = 1;
    private final static int LIMITED_NUMBER = 45;

    public final static int LOTTO_NUMBERS_COUNT = 6;

    private static List<LottoNumber> numbers = IntStream.rangeClosed(INIT_NUMBER, LIMITED_NUMBER)
                                                        .mapToObj(LottoNumber::new)
                                                        .collect(toList());

    private LottoNumbers(){}

    public static Set<LottoNumber> getLottoNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                      .limit(LOTTO_NUMBERS_COUNT)
                      .collect(Collectors.toSet());
    }
}