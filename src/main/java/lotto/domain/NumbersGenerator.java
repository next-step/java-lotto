package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersGenerator {
    static List<Integer> numbers = Stream.iterate(1, n -> n + 1)
            .limit(45)
            .collect(Collectors.toList());

    public static List<Integer> generate(int length) {
        Collections.shuffle(numbers);

        return numbers.subList(0, length);
    }
}
