package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoGenerator() {
    }

    public static List<LottoNumber> generateTotalLotto(int countOfLotto) {
        return IntStream.range(0, countOfLotto)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
    }

    private static LottoNumber generateLotto() {
        List<Integer> numbers = IntStream.rangeClosed(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        java.util.Collections.shuffle(numbers);

        List<Integer> lottoNumbers = numbers.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        return new LottoNumber(lottoNumbers);
    }
}
