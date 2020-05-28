package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {

    private static final List<Integer> LOTTO_NUMBER_GROUP =
            IntStream.rangeClosed(LottoNumber.MIN_VALUE, LottoNumber.MAX_VALUE)
                    .boxed()
                    .collect(Collectors.toList());

    private static final int LOTTO_NUMBER_MAX_COUNT = 6;

    private LottoNumberGenerator() {
    }

    public static List<LottoNumber> generate() {
        Collections.shuffle(LOTTO_NUMBER_GROUP);

        return LOTTO_NUMBER_GROUP.stream()
                .limit(LOTTO_NUMBER_MAX_COUNT)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }
}
