package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberFactory {

    private LottoNumberFactory() {
    }

    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 45;
    private static final int START_POSITION = 0;
    private static final int END_POSITION = 6;

    public static List<Integer> generateNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(MIN_BOUND, MAX_BOUND)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);
        List<Integer> subNumbers = numbers.subList(START_POSITION, END_POSITION);
        Collections.sort(subNumbers);

        return Collections.unmodifiableList(subNumbers);
    }
}
