package lottos.domain;

import lottos.domain.numbers.Numbers;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoRandomGenerator implements LottoGenerator {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    @Override
    public Numbers generate(final int size) {
        List<Integer> values = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(values);

        List<Integer> numbers = values.stream()
                .limit(size)
                .sorted()
                .collect(Collectors.toList());

        return Numbers.from(numbers);
    }
}

