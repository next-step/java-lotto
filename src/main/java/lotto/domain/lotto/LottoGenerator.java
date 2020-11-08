package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private static final List<Integer> numbers = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static Lotto getRandomLotto() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(Lotto.NUMBER_COUNT)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lotto::ofNumbers));
    }
}
