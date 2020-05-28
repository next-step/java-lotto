package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<Integer> LOTTO_NUMBER_GROUP = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumberGenerator() {
    }

    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    public static List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBER_GROUP);

        return LOTTO_NUMBER_GROUP.stream()
                .limit(LOTTO_NUMBER_MAX_COUNT)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
