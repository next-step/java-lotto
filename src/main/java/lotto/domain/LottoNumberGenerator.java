package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import static lotto.domain.Lotto.LOTTO_LENGTH;

public class LottoNumberGenerator {
    private static List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(1,45).boxed().collect(Collectors.toList());

    public static List<Integer> generate() {
        Collections.shuffle(LOTTO_NUMBERS);

        return LOTTO_NUMBERS.subList(0, LOTTO_LENGTH);
    }
}
