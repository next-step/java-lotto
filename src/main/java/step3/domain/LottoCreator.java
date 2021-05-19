package step3.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoCreator {

    private static final List<Integer> numbers = Stream.iterate(1, i -> i + 1)
                                                       .limit(45)
                                                       .collect(toList());

    public static Lotto create() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }
}
