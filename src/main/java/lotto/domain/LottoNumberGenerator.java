package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoNumberGenerator implements NumberGenerator {

    private static final int FIRST_NUMBER = 1;
    private static final int LAST_NUMBER = 45;
    private static final int PEEK_COUNT = 6;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = IntStream.rangeClosed(FIRST_NUMBER, LAST_NUMBER)
                .boxed()
                .collect(toList());

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(PEEK_COUNT)
                .collect(toList());
    }
}
