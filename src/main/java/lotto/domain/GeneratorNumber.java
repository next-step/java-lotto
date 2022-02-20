package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneratorNumber {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int LIMIT_MINIMUM_NUMBER = 1;
    private static final int LIMIT_MAXIMUM_NUMBER = 45;
    private static final List<String> numbers = IntStream.range(
            LIMIT_MINIMUM_NUMBER,
            LIMIT_MAXIMUM_NUMBER + 1
        )
        .boxed()
        .map(number -> Integer.toString(number))
        .collect(Collectors.toList());

    private GeneratorNumber() {
    }

    public static List<String> generateLottoNumbers() {
        Collections.shuffle(numbers);
        final List<String> lottoNumbers = numbers.subList(0, LOTTO_NUMBERS_SIZE);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }
}
