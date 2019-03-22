package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList())
        ;
    }

    public static LottoNumbers randomNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new LottoNumbers(LOTTO_NUMBERS.subList(0, LottoNumbers.TOTAL_NUMBER_OF_THE_LOTTO));
    }
}
