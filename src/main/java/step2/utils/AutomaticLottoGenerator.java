package step2.utils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import step2.model.LottoNumber;

public final class AutomaticLottoGenerator {

    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    private static List<LottoNumber> numbers = IntStream.rangeClosed(START_LOTTO_NUMBER, END_LOTTO_NUMBER)
        .mapToObj(LottoNumber::of)
        .collect(Collectors.toList());

    public static List<LottoNumber> createLottoNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
            .limit(COUNT_OF_LOTTO_NUMBER)
            .sorted()
            .collect(Collectors.toList());
    }
}
