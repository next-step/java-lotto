package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Generator {
    private final List<Integer> numbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public Lotto run () {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
