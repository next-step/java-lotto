package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator {
    private static final List<Integer> numbers = IntStream.range(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER + 1)
            .boxed()
            .collect(Collectors.toList());

    private LottoNumberGenerator() {
    }

    public static List<Integer> getNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream()
                .limit(Lotto.NUMBER_COUNT)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
