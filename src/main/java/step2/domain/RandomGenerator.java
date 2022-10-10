package step2.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements LottoNumbersGenerator {
    private final List<Integer> LOTTO_NUMBERS = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    private final int PICK_NUMBER_COUNT = 6;

    public LottoNumbers create() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> randomNumbers = LOTTO_NUMBERS.stream()
                .limit(PICK_NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toList());
        return new LottoNumbers(randomNumbers);
    }
}
