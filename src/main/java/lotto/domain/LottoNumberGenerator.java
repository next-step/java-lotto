package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private LottoNumberGenerator() {
    }

    public static Lotto generate() {

        List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_NUMBER, Lotto.MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> selected = numbers.subList(0, Lotto.LOTTO_SIZE);
        Collections.sort(selected);

        return new Lotto(selected);
    }
}
