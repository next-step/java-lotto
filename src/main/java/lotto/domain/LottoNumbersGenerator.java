package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbersGenerator {

    private static final List<Integer> LOTTONUMBERS = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());


    public static LottoNumbers generate() {
        Collections.shuffle(LOTTONUMBERS);
        return new LottoNumbers(
                LOTTONUMBERS.subList(0, 6).stream()
                        .mapToInt(Integer::new)
                        .toArray()
        );
    }
}
