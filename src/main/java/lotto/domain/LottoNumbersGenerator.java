package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private static final List<Integer> LOTTONUMBERS = IntStream.rangeClosed(Lotto.MINIMUM_NUMBER, Lotto.MAXIMUM_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    public static LottoNumbers generate() {
        Collections.shuffle(LOTTONUMBERS);
        return new LottoNumbers(
                LOTTONUMBERS.subList(LottoNumbers.INIT_INDEX, LottoNumbers.SIZE).stream()
                        .mapToInt(Integer::new)
                        .toArray()
        );
    }
}
