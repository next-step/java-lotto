package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumbers.NUMBER_COUNT;

public class LottoNumberGenerator {

    public static final int FINAL_NUMBER = 45;

    public static LottoNumbers generate() {
        return generate(NUMBER_COUNT);
    }
    public static LottoNumbers generate(int numberCount) {
        List<LottoNumber> numbers = IntStream.rangeClosed(1, FINAL_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(numbers);

        return new LottoNumbers(numbers.subList(0, numberCount));
    }
}
