package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    public static final int NUMBER_COUNT = 6;
    public static final int FINAL_NUMBER = 45;

    public static LottoNumbers generate() {
        List<LottoNumber> numbers = IntStream.rangeClosed(1, FINAL_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        return new LottoNumbers(numbers.subList(0, NUMBER_COUNT));
    }
}
