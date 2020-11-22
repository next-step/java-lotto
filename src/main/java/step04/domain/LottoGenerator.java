package step04.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> RANGE =
        IntStream.range(LottoBall.START, LottoBall.END)
                 .boxed()
                 .collect(Collectors.toList());

    private LottoGenerator() { }

    public static Lotto generate() {
        Collections.shuffle(RANGE);

        return Lotto.of(
                RANGE.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList())
        );
    }

}
