package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
    private static final int DEFAULT_LOTTO_SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public Lotto publish() {
        List<LottoNumber> randomNumbers = shuffleNumbers();
        return new Lotto(
                IntStream.range(0, DEFAULT_LOTTO_SIZE)
                        .boxed()
                        .map(randomNumbers::get)
                        .collect(Collectors.toList()));
    }

    private List<LottoNumber> shuffleNumbers() {
        List<LottoNumber> randomNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        Collections.shuffle(randomNumbers);
        return randomNumbers;
    }
}
