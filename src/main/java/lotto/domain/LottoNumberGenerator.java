package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static lotto.domain.Lotto.LOTTO_END_NUMBER;
import static lotto.domain.Lotto.LOTTO_LENGTH;
import static lotto.domain.Lotto.LOTTO_START_NUMBER;

public class LottoNumberGenerator {
    private final static List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_END_NUMBER)
            .boxed().collect(Collectors.toList());

    public static Set<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return new HashSet<>(LOTTO_NUMBERS.subList(0, LOTTO_LENGTH));
    }
}
