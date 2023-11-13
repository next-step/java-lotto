package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    public static final int MIN_LOTTO_BOUND = 1;
    public static final int MAX_LOTTO_BOUND = 45;
    private static final int START_POSITION = 0;
    private static final int END_POSITION = 6;
    private static final List<Integer> LOTTO_NUMBERS = IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
            .boxed()
            .collect(Collectors.toList());

    public static List<Integer> generateNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> subNumbers = LOTTO_NUMBERS.subList(START_POSITION, END_POSITION);
        Collections.sort(subNumbers);

        return Collections.unmodifiableList(subNumbers);
    }
}
