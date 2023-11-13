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

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_LOTTO_BOUND, MAX_LOTTO_BOUND)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> subNumbers = numbers.subList(START_POSITION, END_POSITION);
        Collections.sort(subNumbers);

        return Collections.unmodifiableList(subNumbers);
    }
}
