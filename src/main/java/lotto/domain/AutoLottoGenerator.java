package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class AutoLottoGenerator implements LottoGenerator {
    private static final List<Integer> LOTTO_NUMBER_BOX = IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
            .boxed()
            .collect(toList());

    private final List<Integer> numbers;

    public AutoLottoGenerator() {
        this.numbers = LOTTO_NUMBER_BOX;
    }

    @Override
    public Lotto generate() {
        return Lotto.of(generateAutoNumbers());
    }

    private Set<LottoNumber> generateAutoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(Lotto.LOTTO_SIZE)
                .map(LottoNumber::of)
                .collect(toSet());
    }
}
