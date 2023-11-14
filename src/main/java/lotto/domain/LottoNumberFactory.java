package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    private static final int START_POSITION = 0;
    private static final int END_POSITION = 6;
    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.MIN_LOTTO_BOUND, LottoNumber.MAX_LOTTO_BOUND)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> generateNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> subNumbers = LOTTO_NUMBERS.subList(START_POSITION, END_POSITION);
        Collections.sort(subNumbers);

        return Collections.unmodifiableList(subNumbers);
    }
}
